package com.harman.services.spinnaker;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harman.pojo.TagDetails;
import com.harman.pojo.aws.AppDetails;
import com.harman.pojo.aws.AsgDetailsAWS;
import com.harman.pojo.aws.ClusterDetailsAWS;
import com.harman.pojo.gcp.AsgDetailsGCP;
import com.harman.pojo.gcp.ClusterDetailsGCP;

public class ThreadForGetRequest extends Thread {
	private String url;
	HashMap<String, String> headers = new HashMap<String, String>();
	private String appName;
	private String infra;
	private List<AppDetails> apps;

	ThreadForGetRequest(String url, HashMap<String, String> headers, String appName, String infra,
			List<AppDetails> apps) {
		this.url = url;
		this.headers = headers;
		this.appName = appName;
		this.infra = infra;
		this.apps = apps;

		start(); // starting the thread
	}

	/*
	 * This synchronized method will be used by each thread to insert object of the
	 * application for which that thread is responsible.
	 */
	synchronized public void addToApps(AppDetails app) {
		apps.add(app);
	}

	@Override
	public void run() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);

		for (String key : headers.keySet()) {
			request.addHeader(key, headers.get(key));
		}

		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String result = EntityUtils.toString(entity);

				if (infra.compareTo("aws") == 0) {
					ClusterDetailsAWS cluster = new ObjectMapper().readValue(result, ClusterDetailsAWS.class);

					AsgDetailsAWS latestASG = null;
					long latest = 0;

					/*
					 * This for loop is to get the ASG which has been deployed recently from the
					 * list of ASGs present in the cluster.
					 */
					for (AsgDetailsAWS asgDetails : cluster.getServerGroups()) {
						if (asgDetails.getCreatedTime() > latest) {
							latestASG = asgDetails;
							latest = asgDetails.getCreatedTime();
						}
					}

					AppDetails appDetails = null;

					if (!latestASG.isDisabled()) {
						appDetails = new AppDetails();
						appDetails.setName(appName);
						appDetails.setDeployedOn(latestASG.getCreatedTime());
						appDetails.setInfra("AWS");
						appDetails.setRegion(latestASG.getRegion());

						for (TagDetails tag : latestASG.getAsg().getTags()) {
							appDetails.getTags().put(tag.getKey(), tag.getValue());
						}

						addToApps(appDetails);

					} else {
						// need to do error handling for this case
						System.out.println("Latest ASG is in disabled state. Seems deployment is going on.");
					}

				}

				else {
					ClusterDetailsGCP cluster = new ObjectMapper().readValue(result, ClusterDetailsGCP.class);

					AsgDetailsGCP latestASG = null;
					long latest = 0;
					
					for (AsgDetailsGCP asgDetails : cluster.getServerGroups()) {
						if (asgDetails.getCreatedTime() > latest) {
							latestASG = asgDetails;
							latest = asgDetails.getCreatedTime();
						}
					}

					AppDetails appDetails = null;

					if (!latestASG.isDisabled()) {
						appDetails = new AppDetails();
						appDetails.setName(appName);
						appDetails.setDeployedOn(latestASG.getCreatedTime());
						appDetails.setInfra("GCP");
						appDetails.setRegion(latestASG.getRegion());

						for (TagDetails tag : latestASG.getLaunchConfig().getInstanceTemplate().getProperties()
								.getMetadata().getItems()) {
							appDetails.getTags().put(tag.getKey(), tag.getValue());
						}

						addToApps(appDetails);

					} else {
						// need to do error handling for this case
						System.out.println("Latest ASG is in disabled state. Seems deployment is going on.");
					}

				}
			} else {
				// need to handle this error scenario
				System.out.println("Null response was returned by get request.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

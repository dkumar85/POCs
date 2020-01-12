package com.harman.services.spinnaker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harman.configurations.spinnaker.SpinnakerPropertiesConfiguration;
import com.harman.pojo.aws.AppDetails;

@Service
public class SpinnakerService {

	@Autowired
	SpinnakerPropertiesConfiguration spinnakerProperties;

	public ResponseEntity<?> getTagsForApplicationAWS(List<String> applications, String account, String infra) {

		/*
		 * This is the common list shared by all the threads to insert object of the
		 * application that is passed to the thread. This list is to be returned by this method.
		 */
		List<AppDetails> apps = new ArrayList<AppDetails>();
		
		List<ThreadForGetRequest> threads = new ArrayList<ThreadForGetRequest>();
		
		String url;

		for (String app : applications) {
			url = <base url> + app + "/clusters/" + account + "/"
					+ spinnakerProperties.getApplicationAndClusterMapping().get(account).get(app);
			try {
				threads.add(new ThreadForGetRequest(url, spinnakerProperties.getHeaders(), app, infra, apps));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (ThreadForGetRequest thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return ResponseEntity.ok(apps);

	}

}

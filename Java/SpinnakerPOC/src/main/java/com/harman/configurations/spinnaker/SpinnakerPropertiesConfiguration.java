package com.harman.configurations.spinnaker;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@PropertySource("classpath:spinnaker.properties")
@ConfigurationProperties
@JsonInclude(JsonInclude.Include.ALWAYS)
public class SpinnakerPropertiesConfiguration {

	private HashMap<String, String> headers;
	private HashMap<String, String> applicationAndClusterMappingDevINTAWS;
	private HashMap<String, String> applicationAndClusterMappingSTGAWS;
	private HashMap<String, String> applicationAndClusterMappingPRDAWS;
	private HashMap<String, String> applicationAndClusterMappingDevINTGCP;
	private HashMap<String, String> applicationAndClusterMappingSTGGCP;
	private HashMap<String, String> applicationAndClusterMappingPRDGCP;
	private HashMap<String, HashMap<String, String>> applicationAndClusterMapping = new HashMap<String, HashMap<String, String>>();
	private ArrayList<String> importantTagsASR;
	private ArrayList<String> importantTagsTTS;
	private ArrayList<String> importantTagsPDSS;

	@PostConstruct	
	public void setApplicationAndClusterMapping() {
		applicationAndClusterMapping.put("bixby2-dev", applicationAndClusterMappingDevINTAWS);
		applicationAndClusterMapping.put("bixby2-stg", applicationAndClusterMappingSTGAWS);
		applicationAndClusterMapping.put("bixby2-prd", applicationAndClusterMappingPRDAWS);
		applicationAndClusterMapping.put("bixby-int", applicationAndClusterMappingDevINTGCP);
		applicationAndClusterMapping.put("bixby-stg", applicationAndClusterMappingSTGGCP);
		applicationAndClusterMapping.put("bixby-prod", applicationAndClusterMappingPRDGCP);
	}

}

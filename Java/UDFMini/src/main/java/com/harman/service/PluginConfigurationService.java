package com.harman.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harman.configuration.PluginProperties;

@Service
public class PluginConfigurationService {

	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	PluginProperties pluginProperties;
	
	public void printPluginConfiguration() {
		System.out.println("\nPrinting content of property file");
		System.out.println("---------------------------------");
		System.out.println("Jenkins URL: " + pluginProperties.getJenkinsProperties().getUrl());
		System.out.println("Jenkins polling interval: " + pluginProperties.getJenkinsProperties().getPollingInterval());
		System.out.println("\nSpinnaker URL: " + pluginProperties.getSpinnakerProperties().getUrl());
		System.out.println("Spinnaker Mode: " + pluginProperties.getSpinnakerProperties().getMode());
	}

}

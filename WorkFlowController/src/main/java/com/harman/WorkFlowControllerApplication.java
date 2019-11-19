package com.harman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.harman.workflowcontrollerconfiguration.PluginProperties;


@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties(PluginProperties.class)
public class WorkFlowControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkFlowControllerApplication.class, args);
	}

}

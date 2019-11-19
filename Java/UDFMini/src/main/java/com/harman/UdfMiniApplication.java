package com.harman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.harman.configuration.PluginProperties;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties(PluginProperties.class)
public class UdfMiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdfMiniApplication.class, args);
	}

}

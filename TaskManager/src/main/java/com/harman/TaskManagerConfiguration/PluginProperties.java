package com.harman.TaskManagerConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * This class reads all the configuration related to plugings.
 * It is one variable for each plug-in type such as Jira, Spinnaker etc.
 * This properties are read at the boot up time and used throughout the program
 * by injecting the singleton bean to this class.
 * 
 * @author Dharam 
 *@since 2019-10-13
 */

@Configuration
@PropertySource("classpath:plugindetails.properties")
@ConfigurationProperties (prefix = "plugin")
public class PluginProperties {
	

	private JenkinsProperties jenkinsProperties;
	private SpinnakerProperties spinnakerProperties;
	
	public PluginProperties() {
		super();
	}
	
	public PluginProperties(JenkinsProperties jenkinsProperties, SpinnakerProperties spinnakerProperties) {
		super();
		this.jenkinsProperties = jenkinsProperties;
		this.spinnakerProperties = spinnakerProperties;
	}
	
	public JenkinsProperties getJenkinsProperties() {
		return jenkinsProperties;
	}
	public void setJenkinsProperties(JenkinsProperties jenkinsProperties) {
		this.jenkinsProperties = jenkinsProperties;
	}
	public SpinnakerProperties getSpinnakerProperties() {
		return spinnakerProperties;
	}
	public void setSpinnakerProperties(SpinnakerProperties spinnakerProperties) {
		this.spinnakerProperties = spinnakerProperties;
	}

	@Override
	public String toString() {
		return "PluginProperties [jenkinsProperties=" + jenkinsProperties + ", spinnakerProperties="
				+ spinnakerProperties + "]";
	}

}

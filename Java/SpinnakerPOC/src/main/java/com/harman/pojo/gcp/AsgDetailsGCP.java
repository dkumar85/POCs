package com.harman.pojo.gcp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsgDetailsGCP {
	private long createdTime;
	private boolean disabled;
	private String region;
	private LaunchConfig launchConfig;
}

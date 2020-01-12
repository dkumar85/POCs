package com.harman.pojo.aws;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * This is the topmost class that represents cluser details returned by Spinnaker.
 */

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterDetailsAWS {

	private String accountName;
	private String type;
	private List<AsgDetailsAWS> serverGroups=null;

}

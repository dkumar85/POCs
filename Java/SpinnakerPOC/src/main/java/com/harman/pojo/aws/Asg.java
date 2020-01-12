package com.harman.pojo.aws;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.harman.pojo.TagDetails;

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
public class Asg {

	private String autoScalingGroupName;
	private List<TagDetails> tags = null;

}

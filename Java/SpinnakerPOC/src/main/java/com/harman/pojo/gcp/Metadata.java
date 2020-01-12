package com.harman.pojo.gcp;

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
public class Metadata {
	private String fingerprint;
	private List<TagDetails> items;

}

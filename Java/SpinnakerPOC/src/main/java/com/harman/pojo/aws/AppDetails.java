package com.harman.pojo.aws;

import java.util.HashMap;
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
public class AppDetails {
	private String name;
	private long deployedOn;
	private String infra;
	private String region;
	HashMap<String, String> tags= new HashMap<String, String>();
}

package com.harman.controllers.spinnaker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harman.services.spinnaker.SpinnakerService;

@RestController
@RequestMapping("/spinnaker")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	SpinnakerService SpinnakerService;

	@GetMapping(value = "/gettags")
	public ResponseEntity<?> getTagsForApplication(
			@RequestParam(name = "applications", required = true) ArrayList<String> applications,
			@RequestParam(name = "account", required = true) String account,
			@RequestParam(name = "infra", required = true) String infra) throws Exception {
		
		return SpinnakerService.getTagsForApplicationAWS(applications, account, infra);
		
	}

}

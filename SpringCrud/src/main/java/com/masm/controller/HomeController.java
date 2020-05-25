package com.masm.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masm/services")
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/home")
	public String getHome() {

		logger.debug("Inside gethome");
		logger.info("info Message");
		logger.error("Error");
		return "Home page";

	}

	// Json Type as a PayLoad

	@PostMapping("/users")
	public Map<String, Serializable> addBulkUsers(@RequestBody Map<String, ?> uData) {

		Map<String, Serializable> response = new HashMap<String, Serializable>();
		logger.debug("uData " + uData);

		if (uData == null || uData.isEmpty()) {
			response.put("reason", "Empty");
			response.put("result", "failed");
		}

		response.put("userData", (Serializable) uData);

		return response;
	}

}

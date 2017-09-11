package com.ggktech.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggktech.service.impl.ReadinessCheckService;

@RestController
public class ReadinessCheckController {
	private static final Logger LOG = LoggerFactory.getLogger(ReadinessCheckController.class);

	@Autowired
	private ReadinessCheckService readinessCheckService;

	@RequestMapping(value = { "/.well-known/ready" }, method = { GET, HEAD })
	public ResponseEntity<String> live(HttpServletRequest request, HttpServletResponse response) {
		
		// Minimal implementation: always ready
		// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		// Implementation with checking through a service
		ResponseEntity<String> re = null;
		boolean ready = readinessCheckService.isReady();

		if (ready) {
			re = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		} else {
			re = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOG.info("Readiness check returns {}", ready);

		return re;
	}
}

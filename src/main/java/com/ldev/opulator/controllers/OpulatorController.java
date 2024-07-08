package com.ldev.opulator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldev.opulator.services.OpulatorService;

@RestController
public class OpulatorController {

	@Autowired
	OpulatorService populatorService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "start")
	public ResponseEntity<Boolean> startPopulation() {
		try {
			populatorService.startPopulatingDatabase();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("stop")
	public ResponseEntity<Boolean> stop() {
		try {
			populatorService.stopPopulatingDatabase();
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("hello world", HttpStatus.OK);
	}
}

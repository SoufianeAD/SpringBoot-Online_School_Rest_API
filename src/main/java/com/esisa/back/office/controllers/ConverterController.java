package com.esisa.back.office.controllers;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/converter")
public class ConverterController {
	
	@PostMapping("/toHexString")
	public String toHexString(@RequestBody ObjectId id) {
		System.out.println(id.toHexString());
		return id.toHexString();
	}
}

package com.example.contoller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping("/page1")
	public String page1() {
		return "index1";
	}
	
	@RequestMapping("/page2")
	public String page2() {
		return "index2";
	}
}

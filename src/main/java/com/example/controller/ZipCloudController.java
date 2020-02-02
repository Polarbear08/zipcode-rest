package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.AddressResponse;
import com.example.service.ZipCloudService;

@Controller
public class ZipCloudController {
	
	private final ZipCloudService zipCloudService;
	
	public ZipCloudController(ZipCloudService zipCloudService) {
		this.zipCloudService = zipCloudService;
	}
	
	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/result")
	public String result(@RequestParam("zipcode") String zipcode, Model model) {
		AddressResponse addressResponse = zipCloudService.findByZipcode(zipcode);
		model.addAttribute("addressResponse", addressResponse);
		return "result";
	}
}

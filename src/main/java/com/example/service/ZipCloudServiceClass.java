package com.example.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.common.ResponseHeaderInterceptor;
import com.example.dto.AddressResponse;
import com.example.dto.ZipCloudResponse;

@Service
public class ZipCloudServiceClass implements ZipCloudService {
	
	private final String URL = "http://zip-cloud.appspot.com/api/search?zipcode={zipcode}";
	private final RestTemplate restTemplate;
	
	public ZipCloudServiceClass(RestTemplateBuilder restTemplateBuilder, ResponseHeaderInterceptor interceptor) {
		restTemplate = restTemplateBuilder.additionalInterceptors(interceptor).build();
	}
	
	@Override
	public AddressResponse findByZipcode(String zipcode) {
		ZipCloudResponse zipCloudResponse = restTemplate.getForObject(URL, ZipCloudResponse.class, zipcode);
		return zipCloudResponse.getResults().get(0);
	}

}

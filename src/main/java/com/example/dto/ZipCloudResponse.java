package com.example.dto;

import java.util.List;

import lombok.Data;

@Data
public class ZipCloudResponse {
	String message;
	List<AddressResponse> results;
	String status;
}

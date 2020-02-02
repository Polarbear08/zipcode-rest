package com.example.service;

import com.example.dto.AddressResponse;

public interface ZipCloudService {
	AddressResponse findByZipcode(String zipcode);
}

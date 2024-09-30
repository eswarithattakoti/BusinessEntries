package com.andromeda.fintrack.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.andromeda.fintrack.dto.CompanyMasterDto;

public interface CompanyService {
	
	ResponseEntity<List<CompanyMasterDto>> getCompanyDetails();
	
	public ResponseEntity<String> insertCompanyDetails(List<CompanyMasterDto> companyMasterList);
	
	//public ResponseEntity<String> updateCompanyDetails(int companyId,CompanyMasterDto companyMasterDto);
	
	ResponseEntity<String> deleteCompany(int companyId);

}

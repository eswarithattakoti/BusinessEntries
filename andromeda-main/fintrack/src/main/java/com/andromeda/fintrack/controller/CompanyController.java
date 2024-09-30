package com.andromeda.fintrack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.fintrack.dto.CompanyMasterDto;
import com.andromeda.fintrack.service.CompanyService;

@RestController
@RequestMapping("/fintrack")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@GetMapping("/companyDetails")
	public ResponseEntity<List<CompanyMasterDto>> getCompanyDetails(){
		return companyService.getCompanyDetails();
	}
	
	@PostMapping("/companyDetails")
	public ResponseEntity<String> insertCompanyDetails(@RequestBody List<CompanyMasterDto> companyMasterList) {
		return companyService.insertCompanyDetails(companyMasterList);
		
	}
	
	@PutMapping("/companyDetails")
	public ResponseEntity<String> updateCompanyDetails(@PathVariable("companyId") int companyId,@RequestBody CompanyMasterDto companyMasterDto) {
		return companyService.updateCompanyDetails(companyId,companyMasterDto);
		
	}
	
	@DeleteMapping("/companyDetails")
	public ResponseEntity<String> deleteCompany(@PathVariable("companyId") int companyId) {
		return companyService.deleteCompany(companyId);
	}
	
}

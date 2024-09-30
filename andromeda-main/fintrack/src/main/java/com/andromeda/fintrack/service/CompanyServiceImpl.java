package com.andromeda.fintrack.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andromeda.fintrack.dto.CompanyMasterDto;
import com.andromeda.fintrack.entity.CompanyMasterEntity;
import com.andromeda.fintrack.repo.CompanyRepository;
import com.andromeda.fintrack.util.Utility;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Override
	public ResponseEntity<List<CompanyMasterDto>> getCompanyDetails() {
		return new ResponseEntity<List<CompanyMasterDto>>(companyRepo.findAll().stream()
				.map(companyMaster -> convertToDto(companyMaster)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> insertCompanyDetails(List<CompanyMasterDto> companyMasterList) {
		companyRepo.saveAll(companyMasterList.stream().map(companyMaster -> convertToEntity(companyMaster))
				.collect(Collectors.toList()));
		return new ResponseEntity<String>(Utility.SAVED,HttpStatus.OK);
	}

//	@Override
//	public ResponseEntity<String> updateCompanyDetails(int companyId, CompanyMasterDto companyMasterDto) {
//		Optional<CompanyMasterEntity>  companyMasterEntity = companyRepo.findById(companyId);
//		if(companyMasterEntity!=null) {
//			CompanyMasterEntity updateCompanyMasterEntity = convertToEntity(companyMasterDto);
//			//updateCompanyMasterEntity.setCompanyId(companyId);
//			
//			companyRepo.save(updateCompanyMasterEntity);
//			return new ResponseEntity<String>(Utility.UPDATE,HttpStatus.OK);
//		}else {
//			return new ResponseEntity<String>(Utility.FAILED,HttpStatus.NO_CONTENT);
//		}
//		
	//}

	@Override
	public ResponseEntity<String> deleteCompany(int companyId) {
		companyRepo.deleteById(companyId);
		return new ResponseEntity<String>(Utility.DELETE,HttpStatus.OK);
	}
	
	
	private CompanyMasterEntity convertToEntity(CompanyMasterDto companyMasterDto) {
		return modelMapper.map(companyMasterDto, CompanyMasterEntity.class);
		
	}
	
	private CompanyMasterDto convertToDto(CompanyMasterEntity companyMasterEntity) {
		return modelMapper.map(companyMasterEntity, CompanyMasterDto.class);
	}

}

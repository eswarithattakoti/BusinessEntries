package com.andromeda.fintrack.dto;

import lombok.Data;

@Data
public class CompanyMasterDto {
	
	private Integer companyId;
	private String companyName;
	private String street;
	private String city;
	private String state;
	private String phoneNumber;
	private String emailID;
	private String opexPercent;
	private String tdsPercent;
	private String businessLoyaltyPercent;
	private String empProductivityTimes;
	

}

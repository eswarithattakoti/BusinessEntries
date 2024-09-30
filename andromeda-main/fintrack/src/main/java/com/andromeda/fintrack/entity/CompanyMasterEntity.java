package com.andromeda.fintrack.entity;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.andromeda.fintrack.audit.AuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MasterCompany")
@EntityListeners(AuditingEntityListener.class)
@Data
public class CompanyMasterEntity extends AuditEntity<String> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2154810812077087461L;
	
	public CompanyMasterEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CompanyID")
	private Integer companyId;  
	private String companyName;
	@Column(name="Street")
	private String street;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="PhoneNumber")
	private String phoneNumber;
	@Column(name="EmailID")
	private String emailID;
	@Column(name="OPEXPercent")
	private String opexPercent;
	@Column(name="TDSPercent")
	private String tdsPercent;
	@Column(name="BusinessLoyaltyPercent")
	private String businessLoyaltyPercent;
	@Column(name="EmpProductivityTimes")
	private String empProductivityTimes;
	

}

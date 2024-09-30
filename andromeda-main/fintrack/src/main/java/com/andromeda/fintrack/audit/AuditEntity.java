package com.andromeda.fintrack.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditEntity<T> {
	
	@CreatedBy
	@Column(name="CreatedBy", nullable = false, updatable=false)
	protected T createdBy;
	
	@CreatedDate
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="CreatedTimestamp", nullable = false, updatable=false)
	protected LocalDateTime createdTimestamp;
	
	@LastModifiedBy
	@Column(name="ModifiedBy",nullable = false)
	protected T modifiedBy;
	
	@LastModifiedDate
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@Column(name="ModifiedTimestamp", nullable = false)
	protected LocalDateTime modifiedTimestamp;
}

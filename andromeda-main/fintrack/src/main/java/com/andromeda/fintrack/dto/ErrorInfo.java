package com.andromeda.fintrack.dto;

import lombok.Data;

@Data
public class ErrorInfo {
	
	private final String code;
	private final String message;
	
	public ErrorInfo(String code,String message) {
		
		this.code = code;
		this.message = message;
	}

}

package com.pension.process.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PensionerInput {
	private String name;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dateOfBirth;
	
	private String pan;
	private String aadhaarNo;
	private String pensionType; 
	
	

}

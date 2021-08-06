package com.pension.process.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PensionDetail {

	private String name;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	
	private Date dateOfBirth;
	private String pan;
	private String pensionType;
	private double pensionAmount;

}

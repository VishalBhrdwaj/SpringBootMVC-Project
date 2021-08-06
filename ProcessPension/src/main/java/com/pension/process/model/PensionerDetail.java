package com.pension.process.model;

import java.time.LocalDate;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PensionerDetail {
    private String aadharnumber;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateofbirth;
	private String pan;
	private double salaryearned;
	private String allowances;
	private String pensiontype;
	private String bankname;
	private Long accountnumber;
	private String publicorprivate;
	
}
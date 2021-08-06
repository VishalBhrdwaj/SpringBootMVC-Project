package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "PENSIONDETAIL")
public class PensionDetail {
	@Id
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
package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.demo.exception.PensionNotFoundException;
import com.example.demo.model.PensionDetail;
import com.example.demo.repo.PensionRepo;

@Service
public class PensionServiceImpl implements PensionService{
	@Autowired
	PensionRepo pensionrepo;
	
	@Override
	public PensionDetail getPension(String aadharno) {
		Optional<PensionDetail> pensionDetailObj = pensionrepo.findById(aadharno);
		
		if(pensionDetailObj.isPresent())
			return pensionDetailObj.get();
		
		throw new PensionNotFoundException();
	}

	

}

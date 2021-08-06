package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PensionDetail;
import com.example.demo.model.PensionDetail;


@Repository
public interface PensionRepo extends JpaRepository<PensionDetail, java.lang.String>{

	
	
}

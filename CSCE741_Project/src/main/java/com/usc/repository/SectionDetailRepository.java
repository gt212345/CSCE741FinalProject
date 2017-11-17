package com.usc.repository;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.usc.model.SectionDetail;

@RepositoryRestResource
@PropertySource("classpath:application.properties")
public interface SectionDetailRepository extends JpaRepository<SectionDetail, Long>{
	
	String distInstQuery = "Select distinct d.instructor from SectionDetail d"; 
	
	@Query(distInstQuery)
	public List<String> findDistinctByInstructor();
}
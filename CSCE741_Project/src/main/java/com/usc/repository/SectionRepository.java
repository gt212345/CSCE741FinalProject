package com.usc.repository;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.usc.model.Course;
import com.usc.model.Section;

@RepositoryRestResource
@PropertySource("classpath:application.properties")
public interface SectionRepository extends JpaRepository<Course, Long> {
		String instQuery= "Select s from Section s inner join s.sectionDetails d where instructor=:instructor";

		@Query(instQuery)
		public List<Section> getSectionByInst(@Param("instructor") String instructor);
}
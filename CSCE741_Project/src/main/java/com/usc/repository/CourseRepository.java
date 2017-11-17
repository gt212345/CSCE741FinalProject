package com.usc.repository;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.usc.model.Course;

@RepositoryRestResource
@PropertySource("classpath:application.properties")
public interface CourseRepository extends JpaRepository<Course, Long> {
		String instQuery= "Select c from Course c inner join c.sections s "
				+ "inner join s.sectionDetails d where instructor=:instructor";
		String deptQuery= "Select c from Course c where department=:dept";

		String distDeptQuery = "Select distinct c.department from Course c"; 
		
		@Query(distDeptQuery)
		public List<String> findDistinctByDepartment();
		
		@Query(instQuery)
		public List<Course> getCoursesByInst(@Param("instructor") String instructor);
		
		@Query(deptQuery)
		public List<Course> getCoursesByDept(@Param("dept") String dept);
}


package com.proje.repository;

import java.util.List;

import com.proje.model.Education;
import com.proje.model.UserDetails;


public interface EducationRepository {
	
	boolean saveEducation(Education education);
	
	boolean updateEducation(Education education);
	
	boolean removeEducation(Education education);
	
	Education findById(Integer integer);

	UserDetails findWithAdvertisementById(Integer integer);
	
	List<Education> findEducations();

}

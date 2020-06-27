package com.proje.servis;

import java.util.List;

import com.proje.model.Education;
import com.proje.model.UserDetails;

public interface EducationService {
	
boolean saveEducation(Education education);
	
	boolean updateEducation(Education education);
	
	boolean removeEducation(Education education);
	
	Education findById(Integer integer);

	UserDetails findWithAdvertisementById(Integer integer);
	
	List<Education> findEducations();
	
}

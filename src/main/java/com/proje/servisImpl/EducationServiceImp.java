package com.proje.servisImpl;

import java.util.List;

import com.proje.model.Education;
import com.proje.model.UserDetails;
import com.proje.repository.EducationRepository;
import com.proje.repositoryImp.EducationRepositoryImp;
import com.proje.servis.EducationService;

public class EducationServiceImp implements EducationService{
	
	private EducationRepository educationRepository=new EducationRepositoryImp();
	
	
	@Override
	public boolean saveEducation(Education education) {
		return this.educationRepository.saveEducation(education);
	}

	@Override
	public boolean updateEducation(Education education) {
		return this.educationRepository.updateEducation(education);
	}

	@Override
	public boolean removeEducation(Education education) {
		return this.educationRepository.removeEducation(education);
	}

	@Override
	public Education findById(Integer integer) {
		return this.educationRepository.findById(integer);
	}

	@Override
	public UserDetails findWithAdvertisementById(Integer integer) {
		return this.educationRepository.findWithAdvertisementById(integer);
	}

	@Override
	public List<Education> findEducations() {
		return this.educationRepository.findEducations();
	}

}

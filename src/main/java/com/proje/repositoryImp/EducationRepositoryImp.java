package com.proje.repositoryImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactoryImp.JpaFactoryImp;
import com.proje.model.Education;
import com.proje.model.UserDetails;
import com.proje.repository.EducationRepository;

public class EducationRepositoryImp implements EducationRepository{
	
	private JpaFactory factory=new JpaFactoryImp();
	private EntityManager entityManager=factory.getEntityManager();
	private EntityTransaction transaction=factory.getEntityTransaction();
	
	@Override
	public boolean saveEducation(Education education) {
		try {
			transaction.begin();
			entityManager.persist(education);
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("education HATA: "+e);
			
			try {
				this.transaction.rollback();
			} catch (Exception e2) {
				System.out.println("education rollback HATA: "+e);
			}
			
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public boolean updateEducation(Education education) {
		transaction.begin();
		entityManager.merge(education);
		transaction.commit();
		return true;
	}

	@Override
	public boolean removeEducation(Education education) {
		transaction.begin();
		entityManager.remove(education);
		transaction.commit();
		return true;
	}

	@Override
	public Education findById(Integer integer) {
		TypedQuery<Education> typedQuery=this.entityManager.createNamedQuery("Education.findById", Education.class);
		typedQuery.setParameter("educationId", integer);
		return typedQuery.getSingleResult();
	}

	@Override
	public UserDetails findWithAdvertisementById(Integer integer) {
		TypedQuery<UserDetails> typedQuery=this.entityManager.createNamedQuery("Education.findWithAdvertisement", UserDetails.class);
		typedQuery.setParameter("educationId", integer);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Education> findEducations() {
		TypedQuery<Education> typedQuery=this.entityManager.createNamedQuery("Education.findEducations", Education.class);
		return typedQuery.getResultList();
	}

}

package com.proje.repositoryImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactoryImp.JpaFactoryImp;
import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;

public class AdvertisementRepositoryImp implements AdvertisementRepository {
	
	private JpaFactory factory=new JpaFactoryImp();
	private EntityManager entityManager=factory.getEntityManager();
	private EntityTransaction transaction=factory.getEntityTransaction();
	
	@Override
	public boolean saveAdvertisement(Advertisement advertisement) {
		
		try {
			transaction.begin();
			entityManager.persist(advertisement);
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("Advertisement HATA: "+e);
			
			try {
				this.transaction.rollback();
			} catch (Exception e2) {
				System.out.println("Advertisement rollback HATA: "+e);
			}
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public boolean updateAdvertisement(Advertisement advertisement) {
		try {
			
		} catch (Exception e) {
			System.out.println("Advertisement HATA: "+e);
		}
		transaction.begin();
		entityManager.merge(advertisement);
		transaction.commit();
		return true;
	}

	@Override
	public boolean removeAdvertisement(Advertisement advertisement) {
		transaction.begin();
		entityManager.remove(advertisement);
		transaction.commit();
		return true;
	}

	@Override
	public Advertisement findById(int id) {
		TypedQuery<Advertisement> typedQuery=this.entityManager.createNamedQuery("Advertisement.findById", Advertisement.class);
		typedQuery.setParameter("adverId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		TypedQuery<Advertisement> typedQuery=this.entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Advertisement> findByUserName(String userName) {
		TypedQuery<Advertisement> typedQuery=this.entityManager.createNamedQuery("Advertisement.findByUserName", Advertisement.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getResultList();
	}

	@Override
	public List<Advertisement> findAdvertisementsByEntities(int fistResult, int maxResult) {
		TypedQuery<Advertisement> typedQuery=this.entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
		typedQuery.setFirstResult(fistResult);
		typedQuery.setMaxResults(maxResult);
		
		return typedQuery.getResultList();
	}

}

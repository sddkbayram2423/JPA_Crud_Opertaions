package com.proje.repositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactoryImp.JpaFactoryImp;
import com.proje.model.UserDetails;
import com.proje.repository.UserDetailsRepository;

public class UserDetailsRepositoryImp implements UserDetailsRepository {
	
	private JpaFactory factory=new JpaFactoryImp();
	private EntityManager entityManager=factory.getEntityManager();
	private EntityTransaction transaction=factory.getEntityTransaction();
	
	@Override
	public boolean saveUserDetails(UserDetails details) {
		try {
			transaction.begin();
			entityManager.persist(details);
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("details HATA: "+e);
			
			try {
				this.transaction.rollback();
			} catch (Exception e2) {
				System.out.println("details rollback HATA: "+e);
			}
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public boolean updateUserDetails(UserDetails details) {
		transaction.begin();
		entityManager.merge(details);
		transaction.commit();
		return true;
	}

	@Override
	public boolean removeUserDetails(UserDetails details) {
		transaction.begin();
		entityManager.remove(details);
		transaction.commit();
		return true;
	}

	@Override
	public UserDetails findById(int id) {
//		TypedQuery<UserDetails> typedQuery=this.entityManager.createNamedQuery("UserDetails.FindById", UserDetails.class);
//		typedQuery.setParameter("userDetailId", id);
		return null;//typedQuery.getSingleResult();
	}

	@Override
	public UserDetails findWithAdressByUserName(String userName) {
		TypedQuery<UserDetails> typedQuery=this.entityManager.createNamedQuery("UserDetails.FindWithAdressByUserName", UserDetails.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getSingleResult();
	}

	@Override
	public UserDetails findWithAdvertisementByUserName(String userName) {
		TypedQuery<UserDetails> typedQuery=this.entityManager.createNamedQuery("UserDetails.FindWithAdvertisementByUserName", UserDetails.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getSingleResult();
	}

	@Override
	public UserDetails findByUserName(String username) {
		TypedQuery<UserDetails> typedQuery=this.entityManager.createNamedQuery("UserDetails.FindByUserName", UserDetails.class);
		typedQuery.setParameter("userName", username);
		return typedQuery.getSingleResult();
	}

}

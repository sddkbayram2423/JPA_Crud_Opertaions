package com.proje.repositoryImp;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.jpaFactory.JpaFactory;
import com.proje.jpaFactoryImp.JpaFactoryImp;
import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;

public class UserRepositoryImp implements UserRepository  {
	
	private JpaFactory factory=new JpaFactoryImp();
	private EntityManager entityManager=factory.getEntityManager();
	private EntityTransaction transaction=factory.getEntityTransaction();
	
	@Override
	public boolean save(User user) {
		try {
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("user HATA: "+e);
			
			try {
				this.transaction.rollback();
			} catch (Exception e2) {
				System.out.println("user rollback HATA: "+e);
			}
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		transaction.begin();
		entityManager.merge(user);
		transaction.commit();
		return true;
	}

	@Override
	public boolean removeUser(User user) {
		transaction.begin();
		entityManager.remove(user);
		transaction.commit();
		return true;
	}

	@Override
	public User findById(int id) {
		TypedQuery<User> typedQuery=this.entityManager.createNamedQuery("User.findById", User.class);
		typedQuery.setParameter("userId", id);
		return typedQuery.getSingleResult();
	}

	@Override
	public User findByUserName(String userName) {
		TypedQuery<User> typedQuery=this.entityManager.createNamedQuery("User.findByUserName", User.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getSingleResult();
	}

	@Override
	public User findWithUserDetailsByUserName(String userName) {
		TypedQuery<User> typedQuery=this.entityManager.createNamedQuery("User.findWithUserDetailsByUserName", User.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<User> findUsers() {
		TypedQuery<User> typedQuery=this.entityManager.createNamedQuery("User.findUsers", User.class);
		
		return typedQuery.getResultList();
	}

	@Override
	public List<User> findUsers(int fistResult, int maxResult) {
		TypedQuery<User> typedQuery=this.entityManager.createNamedQuery("User.findUsers", User.class);
		typedQuery.setFirstResult(fistResult);
		typedQuery.setMaxResults(maxResult);
		return typedQuery.getResultList();
	}

	@Override
	public int findUserCount() {
		TypedQuery<Long> typedQuery=this.entityManager.createNamedQuery("User.count", Long.class);
		
		return typedQuery.getSingleResult().intValue();
	}

	@Override
	public UserInfo findUserInfoByUserName(String userName) {
		TypedQuery<UserInfo> typedQuery=this.entityManager.createNamedQuery("User.findUserInfoByUserName", UserInfo.class);
		typedQuery.setParameter("userName", userName);
		return typedQuery.getSingleResult();
	}

}

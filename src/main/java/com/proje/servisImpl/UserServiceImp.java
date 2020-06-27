package com.proje.servisImpl;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.UserRepository;
import com.proje.repositoryImp.UserRepositoryImp;
import com.proje.servis.UserService;

public class UserServiceImp implements UserService  {
	
	private UserRepository user=new UserRepositoryImp();
	
	
	@Override
	public boolean save(User user) {
		return this.user.save(user);
	}

	@Override
	public boolean updateUser(User user) {
		return updateUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		return this.user.removeUser(user);
	}

	@Override
	public User findById(int id) {
		return this.user.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		return this.user.findByUserName(userName);
	}

	@Override
	public User findWithUserDetailsByUserName(String userName) {
		return this.user.findWithUserDetailsByUserName(userName);
	}

	@Override
	public List<User> findUsers() {
		return this.user.findUsers();
	}

	@Override
	public List<User> findUsers(int fistResult, int maxResult) {
		return this.user.findUsers(fistResult, maxResult);
	}

	@Override
	public int findUserCount() {
		return this.user.findUserCount();
	}

	@Override
	public UserInfo findUserInfoByUserName(String userName) {
		return this.user.findUserInfoByUserName(userName);
	}

}

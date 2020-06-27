package com.proje.servis;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserInfo;

public interface UserService {
	
	boolean save(User user);

	boolean updateUser(User user);

	boolean removeUser(User user);

	User findById(int id);

	User findByUserName(String userName);

	User findWithUserDetailsByUserName(String userName);

	List<User> findUsers();

	List<User> findUsers(int fistResult, int maxResult);

	int findUserCount();

	UserInfo findUserInfoByUserName(String userName);
	
	
	

}

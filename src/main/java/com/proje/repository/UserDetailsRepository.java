package com.proje.repository;

import com.proje.model.UserDetails;

public interface UserDetailsRepository {
	
	boolean saveUserDetails(UserDetails details);

	boolean updateUserDetails(UserDetails details);

	boolean removeUserDetails(UserDetails details);

	UserDetails findById(int id);
	
	UserDetails findByUserName(String username);

	UserDetails findWithAdressByUserName(String userName);

	UserDetails findWithAdvertisementByUserName(String userName);
	
}

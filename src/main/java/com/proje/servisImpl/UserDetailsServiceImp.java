package com.proje.servisImpl;

import com.proje.model.UserDetails;
import com.proje.repository.UserDetailsRepository;
import com.proje.repositoryImp.UserDetailsRepositoryImp;
import com.proje.servis.UserDetailsService;

public class UserDetailsServiceImp implements UserDetailsService {
	
	private UserDetailsRepository userDetails=new UserDetailsRepositoryImp();

	
	@Override
	public boolean saveUserDetails(UserDetails details) {
		return this.userDetails.saveUserDetails(details);
	}

	@Override
	public boolean updateUserDetails(UserDetails details) {
		return this.userDetails.updateUserDetails(details);
	}

	@Override
	public boolean removeUserDetails(UserDetails details) {
		return this.userDetails.removeUserDetails(details);
	}

	@Override
	public UserDetails findById(int id) {
		return this.userDetails.findById(id);
	}

	@Override
	public UserDetails findWithAdressByUserName(String userName) {
		return this.userDetails.findWithAdressByUserName(userName);
	}

	@Override
	public UserDetails findWithAdvertisementByUserName(String userName) {
		return findWithAdvertisementByUserName(userName);
	}

	@Override
	public UserDetails findByUserName(String username) {
		return findByUserName(username);
	}

}

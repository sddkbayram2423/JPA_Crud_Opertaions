 package com.proje.repository;

import java.util.List;

import com.proje.model.Advertisement;


public interface AdvertisementRepository {
	
	boolean saveAdvertisement(Advertisement advertisement);

	boolean updateAdvertisement(Advertisement advertisement);

	boolean removeAdvertisement(Advertisement advertisement);

	Advertisement findById(int id);

	List<Advertisement> findAdvertisements();

	List<Advertisement> findByUserName(String userName);

	List<Advertisement> findAdvertisementsByEntities(int fistResult, int maxResult);
}

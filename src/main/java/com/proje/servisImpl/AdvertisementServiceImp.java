package com.proje.servisImpl;

import java.util.List;

import com.proje.model.Advertisement;
import com.proje.repository.AdvertisementRepository;
import com.proje.repositoryImp.AdvertisementRepositoryImp;
import com.proje.servis.AdvertisementService;

public class AdvertisementServiceImp implements AdvertisementService {
	
	private  AdvertisementRepository adver=new AdvertisementRepositoryImp();
	
	
	@Override
	public boolean saveAdvertisement(Advertisement advertisement) {
		return this.adver.saveAdvertisement(advertisement);
	}

	@Override
	public boolean updateAdvertisement(Advertisement advertisement) {
		return this.adver.updateAdvertisement(advertisement);
	}

	@Override
	public boolean removeAdvertisement(Advertisement advertisement) {
		return this.adver.removeAdvertisement(advertisement);
	}

	@Override
	public Advertisement findById(int id) {
		return this.adver.findById(id);
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		return this.adver.findAdvertisements();
	}

	@Override
	public List<Advertisement> findByUserName(String userName) {
		return this.adver.findByUserName(userName);
	}

	@Override
	public List<Advertisement> findAdvertisementsByEntities(int fistResult, int maxResult) {
		return this.adver.findAdvertisementsByEntities(fistResult, maxResult);
	}

}

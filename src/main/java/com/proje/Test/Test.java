package com.proje.Test;

import java.util.Date;

import com.proje.model.Adress;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserDetails;
import com.proje.model.util.PhoneType;
import com.proje.servis.AdvertisementService;
import com.proje.servis.EducationService;
import com.proje.servis.UserDetailsService;
import com.proje.servis.UserService;
import com.proje.servisImpl.AdvertisementServiceImp;
import com.proje.servisImpl.EducationServiceImp;
import com.proje.servisImpl.UserDetailsServiceImp;
import com.proje.servisImpl.UserServiceImp;

public class Test {
	public static void main(String[] args) {
		addData();
		
	}
	
	public static void addData() {
		UserService userService=new UserServiceImp();
		UserDetailsService detailsService=new UserDetailsServiceImp();
		AdvertisementService advertisementService=new AdvertisementServiceImp();
		EducationService educationService=new EducationServiceImp();
		
		
		Adress adress=new Adress("Pervane", "Mesai", "Konya"); 
		Adress adress1=new Adress("Karalar", "Selamet", "Erzurum"); 
		Adress adress2=new Adress("Ptt", "Millet", "Izmir"); 
		Adress adress3=new Adress("Çikmaz", "Masal", "Istanbul"); 
		Adress adress4=new Adress("Solmaz", "Kerste", "Ankara"); 
		
		
		Education education=new Education("ITÜ", 4);
		Education education1=new Education("YTÜ", 4);
		Education education2=new Education("HHO", 4);
		Education education3=new Education("ODTÜ", 4);
		Education education4=new Education("IÜ", 4);
		
		Advertisement advertisement=new Advertisement("Egitim", "Matematik Dersi", "Lisans mezunu");
		Advertisement advertisement1=new Advertisement("Isci", "Insaat", "Ilkokul mezunu");
		Advertisement advertisement2=new Advertisement("Yardimci", "Mudur", "Lisans mezunu");
		Advertisement advertisement3=new Advertisement("Sofor", "Direksiyon", "Lise mezunu");
		Advertisement advertisement4=new Advertisement("Ogretmen", "Ingilizce Dersi", "Lisans mezunu");
		
		User user=new User("akara", "46546454", new Date());
		User user1=new User("obaran", "3234876", new Date());
		User user2=new User("akaval", "34324234", new Date());
		User user3=new User("ikara", "34564334", new Date());
		User user4=new User("egundes", "23465768", new Date());
		
		UserDetails userDetails=new UserDetails("Ahmet", "Kara", new Date());
		userDetails.addAdres(adress);
		userDetails.addAdres(adress1);
		userDetails.addAdvertisement(advertisement4);
		userDetails.addAdvertisement(advertisement1);
		userDetails.addPhone(PhoneType.CELL	, "32784327482");
		userDetails.addPhone(PhoneType.WORK	, "4534354354");
		userDetails.setUser(user);
		
		UserDetails userDetails1=new UserDetails("Onur", "Baran", new Date());
		userDetails1.addAdres(adress2);
		userDetails1.addAdres(adress3);
		userDetails1.addAdvertisement(advertisement2);
		userDetails1.addAdvertisement(advertisement4);
		userDetails1.addAdvertisement(advertisement);
		userDetails1.addPhone(PhoneType.HOME, "45435435435");
		userDetails1.setUser(user1);
		
		
		
		UserDetails userDetails2=new UserDetails("Ali", "Kaval", new Date());
		userDetails2.addAdres(adress2);
		userDetails2.addPhone(PhoneType.CELL, "765765865765");
		userDetails2.addPhone(PhoneType.HOME, "353455677");
		userDetails2.addPhone(PhoneType.WORK, "3245325432543");
		userDetails2.setUser(user2);
		
		UserDetails userDetails3=new UserDetails("Ilker", "Kara", new Date());
		userDetails3.addAdres(adress3);
		userDetails3.addAdres(adress4);
		userDetails3.addAdvertisement(advertisement2);
		userDetails3.addPhone(PhoneType.CELL, "4546465464654");
		userDetails3.setUser(user3);
		
		UserDetails userDetails4=new UserDetails("Ebru", "Gundes", new Date());
		userDetails4.addAdvertisement(advertisement4);
		userDetails4.addAdvertisement(advertisement1);
		userDetails4.addAdvertisement(advertisement3);
		userDetails4.addPhone(PhoneType.HOME, "46546465464");
		userDetails4.addPhone(PhoneType.CELL, "12346678769");
		userDetails4.setUser(user4);
		
		education.addAdvertisement(advertisement4);
		education.addAdvertisement(advertisement3);
		education.addAdvertisement(advertisement1);
		
		education2.addAdvertisement(advertisement4);
		education2.addAdvertisement(advertisement);
		
		education3.addAdvertisement(advertisement2);
		education3.addAdvertisement(advertisement4);
		education3.addAdvertisement(advertisement);
		
		
		education1.addAdvertisement(advertisement2);
		education1.addAdvertisement(advertisement1);
		
		
		education4.addAdvertisement(advertisement1);
		education4.addAdvertisement(advertisement4);
		education4.addAdvertisement(advertisement3);
		
		
		advertisement.addEducation(education1);
		advertisement.addEducation(education);
		advertisement.addEducation(education3);
		
		advertisement1.addEducation(education2);
		advertisement1.addEducation(education3);
		advertisement1.addEducation(education4);
		
		advertisement2.addEducation(education3);
		advertisement2.addEducation(education1);
		advertisement2.addEducation(education4);
		
		advertisement3.addEducation(education1);
		advertisement3.addEducation(education2);
		advertisement3.addEducation(education3);
		
		advertisement4.addEducation(education);
		advertisement4.addEducation(education4);
		advertisement4.addEducation(education2);
		
		userService.save(user);
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		userService.save(user4);
		
		detailsService.saveUserDetails(userDetails);
		detailsService.saveUserDetails(userDetails1);
		detailsService.saveUserDetails(userDetails2);
		detailsService.saveUserDetails(userDetails3);
		detailsService.saveUserDetails(userDetails4);
		
		advertisementService.saveAdvertisement(advertisement);
		advertisementService.saveAdvertisement(advertisement1);
		advertisementService.saveAdvertisement(advertisement2);
		advertisementService.saveAdvertisement(advertisement3);
		advertisementService.saveAdvertisement(advertisement4);
		
		educationService.saveEducation(education);
		educationService.saveEducation(education1);
		educationService.saveEducation(education2);
		educationService.saveEducation(education3);
		educationService.saveEducation(education4);
		
		
	}

}

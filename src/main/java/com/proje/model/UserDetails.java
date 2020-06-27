package com.proje.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.proje.model.util.PhoneType;
@Entity
@NamedQueries({
	@NamedQuery(name="UserDetails.FindByUserName",
				query="SELECT ud from UserDetails ud WHERE ud.user.userName=:userName"),
	@NamedQuery(name="UserDetails.FindWithAdressByUserName",
				query="SELECT ud FROM UserDetails ud LEFT JOÝN FETCH ud.adresses WHERE ud.user.userName=:userName"),
	@NamedQuery(name="UserDetails.FindWithAdvertisementByUserName",
				query="SELECT ud FROM UserDetails ud LEFT JOÝN FETCH ud.advertisements WHERE ud.user.userName=:userName"),
//	@NamedQuery(name="UserDetails.FindById",
//										query="SELECT ud from UserDetails ud WHERE ud.user.userDetailId=:userDetailId"),
})
public class UserDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userDetailId;
	
	private String userName;
	
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@ElementCollection
	@JoinTable(name="userdetail_phonenumber",joinColumns=@JoinColumn(name="userDetailId"))
	@MapKeyColumn(name="phoneType")
	@Column(name="phoneNumber")
	private Map<PhoneType, String> phoneNumbers=new HashMap<PhoneType, String>();
	
	
	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="userdetail_adress",joinColumns=@JoinColumn(name="userDetailId"))
	private List<Adress> adresses=new ArrayList<Adress>();
	
	@OneToMany(mappedBy="userDetails")
	private List<Advertisement> advertisements=new ArrayList<Advertisement>();
	
	@OneToOne(mappedBy="userDetails",cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private User user;

	public UserDetails() {	}

	public UserDetails(String userName, String lastName, Date birthDate) {
		this.userName = userName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public void addAdres(Adress adress) {
		this.adresses.add(adress);
	}
	public void addPhone(PhoneType phoneType,String number) {
		this.phoneNumbers.put(phoneType, number);
	}
	public void addAdvertisement(Advertisement advertisement) {
		this.advertisements.add(advertisement);
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetails [userDetailId=" + userDetailId + ", userName=" + userName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", phoneNumbers=" + phoneNumbers + ", adresses=" + adresses
				+ ", advertisements=" + advertisements + ", user=" + user + "]";
	}

	
	
}

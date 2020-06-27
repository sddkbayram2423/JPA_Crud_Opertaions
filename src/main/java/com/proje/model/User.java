 package com.proje.model;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="User.findById",query="SELECT u FROM User u LEFT JOÝN FETCH u.userDetails WHERE u.userId=:userId"),
	@NamedQuery(name="User.findByUserName",query="SELECT u FROM User u  WHERE u.userName=:userName"),
	@NamedQuery(name="User.findWithUserDetailsByUserName",query="SELECT u FROM User u LEFT JOÝN FETCH u.userDetails WHERE u.userName=:userName"),
	@NamedQuery(name="User.findUsers",query="SELECT u FROM User u "),
	@NamedQuery(name="User.count",query="Select count(u) from User u"),
	@NamedQuery(name="User.findUserInfoByUserName", 
					query="SELECT new com.proje.mode.UserInfo(u.userDetails.userName, u.userDetails.lastName,u.userDetails.birthDate) "
								+ "FROM User u WHERE u.userName=:userName")
})
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	

	@OneToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private UserDetails userDetails;
	
	public User() {	}

	public User(String userName, String password, Date creationDate) {
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", creationDate="
				+ creationDate + ", userDetails=" + userDetails + "]";
	} 
	
	
	
	
	

}

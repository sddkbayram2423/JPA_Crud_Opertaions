package com.proje.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Advertisement.findAdvertisements",query="SELECT a FROM Advertisement a "),
	@NamedQuery(name="Advertisement.findById",query="SELECT a FROM Advertisement a LEFT JOÝN FETCH a.educations WHERE a.adverId=:adverId "),
	@NamedQuery(name="Advertisement.findByUserName",
					 query="SELECT a FROM User u LEFT JOÝN u.userDetails ud LEFT JOÝN ud.advertisements a WHERE u.userName=:userName")
})
public class Advertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adverId;
	
	private String title;
	
	@Lob
	private String workDefination;
	
	@Lob
	private String criters;
	
	@Temporal(TemporalType.DATE)
	private Date addDate=new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	private boolean enabled=false;
	
	private Date removeDate;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	@JoinTable(name="advertisement_education",joinColumns=@JoinColumn(name="adverId"),inverseJoinColumns=@JoinColumn(name="educationId"))
	private List<Education> educations=new ArrayList<Education>();
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=UserDetails.class,cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	@JoinColumn(name="userDetailId")
	private UserDetails userDetails;
	
	
	public Advertisement() {	}
	
	
	public void addEducation(Education education) {
		this.educations.add(education);
	}

	public Advertisement(String title, String workDefination, String criters) {
		this.title = title;
		this.workDefination = workDefination;
		this.criters = criters;
	}


	public Integer getAdverId() {
		return adverId;
	}


	public void setAdverId(Integer adverId) {
		this.adverId = adverId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWorkDefination() {
		return workDefination;
	}


	public void setWorkDefination(String workDefination) {
		this.workDefination = workDefination;
	}


	public String getCriters() {
		return criters;
	}


	public void setCriters(String criters) {
		this.criters = criters;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Date getRemoveDate() {
		return removeDate;
	}


	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}


	public List<Education> getEducations() {
		return educations;
	}


	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	

}

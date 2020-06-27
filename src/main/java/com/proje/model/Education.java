package com.proje.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Education.findEducations",query="SELECT e FROM Education e "),
	@NamedQuery(name="Education.findById",query="SELECT e FROM Education e WHERE e.educationId=:educationId "),
	@NamedQuery(name="Education.findWithAdvertisement",query="SELECT e FROM Education e LEFT JOÝN FETCH e.advertisements WHERE e.educationId=:educationId ")
})
public class Education {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer educationId;
	
	private String educationName;
	
	private int year;
	
	@ManyToMany(mappedBy="educations",cascade= {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	private List<Advertisement> advertisements=new ArrayList<Advertisement>();
	
	public Education() {	}

	public Education(String educationName, int year) {
		this.educationName = educationName;
		this.year = year;
	}
	public void addAdvertisement(Advertisement advertisement) {
		this.advertisements.add(advertisement);
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", educationName=" + educationName + ", year=" + year
				+ ", advertisements=" + advertisements + "]";
	}
	
	

}


package com.iems.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employees")
public class Employee 
{
	@Id
	@Column(name="eid")
	int eid;
	@Column(name="summary")
	String summary;
	@Column(name="dob")
	Date dob;
	@Column(name="passport")
	String passport;
	@Column(name="photo")
	String photo;
	@Column(name="empresume")
	String empResume;
	@Column(name="skillid")
	int skillid;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
	private Profile profile;
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmpResume() {
		return empResume;
	}
	public void setEmpResume(String empResume) {
		this.empResume = empResume;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

}

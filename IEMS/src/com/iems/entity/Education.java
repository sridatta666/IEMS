package com.iems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="education")
public class Education {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	int id;
	@Column(name="eid")
	int eid;
	@Column(name="columnid")
	int columnid;
	@Column(name="degree")
	String degree;
    
	@OneToOne(mappedBy="education", cascade=CascadeType.ALL)
	private Profile profile;
	
	
	
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getColumnid() {
		return columnid;
	}
	public void setColumnid(int columnid) {
		this.columnid = columnid;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
}

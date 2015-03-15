package com.iems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



	@Entity
	@Table(name="experience")
	public class Experience {	

		@Id
		@Column(name="eid")
		int eid;
		@Column(name="columnid")
		int columnid;
		@Column(name="organization")
		String organization;
		
		@OneToOne(mappedBy="experience", cascade=CascadeType.ALL)
		private Profile profile;
		
		
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
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		public Profile getProfile() {
			return profile;
		}
		public void setProfile(Profile profile) {
			this.profile = profile;
		}	
	
}

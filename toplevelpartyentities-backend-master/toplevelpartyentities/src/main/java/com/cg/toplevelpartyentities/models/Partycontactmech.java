package com.cg.toplevelpartyentities.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="PARTYCONTACTMECH")
public class Partycontactmech {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CONTACTMECHID")
	private int contactMechId;
	@Column(name="FROMDATE")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date fromDate;
	@JsonFormat(pattern = "YYYY-MM-dd")
	@Column(name="THRUDATE")
	private Date thruDate;
	@Column(name="ROLETYPEID")
	private int roleTypeId;
	@Column(name="ALLOWSOCIALIZATION")
	private boolean allowSocialization;
	@Column(name="EXTENSION")
	private boolean extension;
	@Column(name="VERIFIED")
	private boolean verified;
	@Column(name="YEARSWITHCONTACTMECH")
	private int yearsWithContactMech;
	@Column(name="MONTHSWITHCONTACTMECH")
	private int monthsWithContactMech;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="PCM_PARTYID", nullable = false)
	@JsonBackReference(value="party-partycontactmech")
	private Party party;
	
	@JsonManagedReference(value="partycontactmech-contactmech")
	@OneToMany(mappedBy="partycontactmech", cascade = CascadeType.ALL)
	private List<Contactmech> contactmech;
	
	
	
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="PCM_CONTACTMECHID", nullable = false)
	 * 
	 * @JsonBackReference(value="contactmech-partycontactmech") private Contactmech
	 * contactmech;
	 */

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getThruDate() {
		return thruDate;
	}

	public void setThruDate(Date thruDate) {
		this.thruDate = thruDate;
	}

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public boolean isAllowSocialization() {
		return allowSocialization;
	}

	public void setAllowSocialization(boolean allowSocialization) {
		this.allowSocialization = allowSocialization;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getYearsWithContactMech() {
		return yearsWithContactMech;
	}

	public void setYearsWithContactMech(int yearsWithContactMech) {
		this.yearsWithContactMech = yearsWithContactMech;
	}

	public int getMonthsWithContactMech() {
		return monthsWithContactMech;
	}

	public void setMonthsWithContactMech(int monthsWithContactMech) {
		this.monthsWithContactMech = monthsWithContactMech;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public int getContactMechId() {
		return contactMechId;
	}

	public void setContactMechId(int contactMechId) {
		this.contactMechId = contactMechId;
	}

	public List<Contactmech> getContactmech() {
		return contactmech;
	}

	public void setContactmech(List<Contactmech> contactmech) {
		this.contactmech = contactmech;
	}

	

}

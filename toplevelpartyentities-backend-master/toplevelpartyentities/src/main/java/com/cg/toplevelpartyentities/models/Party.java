package com.cg.toplevelpartyentities.models;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;*/
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="PARTY")

public class Party implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PARTYID")
	private int partyId;
	@Column(name="PARTYTYPEID")
	private int partyTypeId;
	@Column(name="EXTERNALID")
	private int externalId;
	@Column(name="CURRENCYUOMID")
	private int currencyUomId;
	@Column(name="DESCRIPTIONS")
	private String description;
	@Column(name="STATUSID")
	private int statusId;
	
	//@JsonIgnore
	@JsonManagedReference(value="party-partygroup")
	@OneToMany(mappedBy="party", cascade = CascadeType.ALL)
	private List<Partygroup> partygroup;
	
	//@JsonIgnore
	@JsonManagedReference(value="party-person")
	@OneToMany(mappedBy="party", cascade = CascadeType.ALL)
	private List<Person> person;
	
	@JsonManagedReference(value="party-userlogin")
	@OneToMany(mappedBy="party", cascade = CascadeType.ALL)
	private List<Userlogin> userlogin;
	
	@JsonManagedReference(value="party-partycontactmech")
	@OneToMany(mappedBy="party", cascade = CascadeType.ALL)
	private List<Partycontactmech> partycontactmech;
	
	@JsonManagedReference(value="party-partyrole")
	@OneToMany(mappedBy="party", cascade = CascadeType.ALL)
	private List<Partyrole> partyrole;
	
	public Party() {
		
	}
	
	
	
	public Party(int partyId, int partyTypeId, int externalId, int currencyUomId, String description, int statusId) {
		super();
		this.partyId = partyId;
		this.partyTypeId = partyTypeId;
		this.externalId = externalId;
		this.currencyUomId = currencyUomId;
		this.description = description;
		this.statusId = statusId;
		
	}
	public List<Partycontactmech> getPartycontactmech() {
		return partycontactmech;
	}
	public void setPartycontactmech(List<Partycontactmech> partycontactmech) {
		this.partycontactmech = partycontactmech;
	}
	public List<Partyrole> getPartyrole() {
		return partyrole;
	}
	public void setPartyrole(List<Partyrole> partyrole) {
		this.partyrole = partyrole;
	}
	public List<Userlogin> getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(List<Userlogin> userlogin) {
		this.userlogin = userlogin;
	}
	public int getPartyId() {
		return partyId;
	}

	
	 public void setPartyId(int partyId) { this.partyId = partyId; }
	 
	public int getPartyTypeId() {
		return partyTypeId;
	}
	public void setPartyTypeId(int partyTypeId) {
		this.partyTypeId = partyTypeId;
	}
	public int getExternalId() {
		return externalId;
	}
	public void setExternalId(int externalId) {
		this.externalId = externalId;
	}
	public int getCurrencyUomId() {
		return currencyUomId;
	}
	public void setCurrencyUomId(int currencyUomId) {
		this.currencyUomId = currencyUomId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public List<Partygroup> getPartygroup() {
		return partygroup;
	}
	public void setPartygroup(List<Partygroup> partygroup) {
		this.partygroup = partygroup;
	}
	public List<Person> getPerson() {
		return person;
	}
	public void setPerson(List<Person> person) {
		this.person = person;
	}
}

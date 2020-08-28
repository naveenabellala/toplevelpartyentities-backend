package com.cg.toplevelpartyentities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="PARTYGROUP")
public class Partygroup {
	    
	@Column(name="GROUPNAME")
	private String groupName;
	@Id
	@Column(name="GROUPNAMELOCAL")
	private String groupNameLocal;
	@Column(name="OFFICESITENAME")
	private String officesiteName;
	@Column(name="COMMENTS")
	private String comments;
	@Column(name="LOGOIMAGEURL")
	private String logoImageUrl;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonProperty("Party")
	@JoinColumn(name="GROUP_PARTYID", nullable = false)
	@JsonBackReference(value="party-partygroup")
	private Party party;
	
	public Party getParty() {
		return party;
	}
	public void setParty(Party party) {
		this.party = party;
	}
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupNameLocal() {
		return groupNameLocal;
	}
	public void setGroupNameLocal(String groupNameLocal) {
		this.groupNameLocal = groupNameLocal;
	}
	public String getOfficesiteName() {
		return officesiteName;
	}
	public void setOfficesiteName(String officesiteName) {
		this.officesiteName = officesiteName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getLogoImageUrl() {
		return logoImageUrl;
	}
	public void setLogoImageUrl(String logoImageUrl) {
		this.logoImageUrl = logoImageUrl;
	}
	

}

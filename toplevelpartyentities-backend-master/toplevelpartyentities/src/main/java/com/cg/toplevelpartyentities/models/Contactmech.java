package com.cg.toplevelpartyentities.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="CONTACTMECH")
public class Contactmech {
	@Id
	@Column(name="CONTACTMECHTYPEID")
	private int contactMechTypeId;
	@Column(name="INFOSTRING")
	private String infoString;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="PCM_CONTACTMECHID", nullable = false)
	@JsonBackReference(value="partycontactmech-contactmech")
	private Partycontactmech partycontactmech;
	

	public int getContactMechTypeId() {
		return contactMechTypeId;
	}

	public void setContactMechTypeId(int contactMechTypeId) {
		this.contactMechTypeId = contactMechTypeId;
	}

	public String getInfoString() {
		return infoString;
	}

	public void setInfoString(String infoString) {
		this.infoString = infoString;
	}

	public Partycontactmech getPartycontactmech() {
		return partycontactmech;
	}

	public void setPartycontactmech(Partycontactmech partycontactmech) {
		this.partycontactmech = partycontactmech;
	}

	
	
	
}

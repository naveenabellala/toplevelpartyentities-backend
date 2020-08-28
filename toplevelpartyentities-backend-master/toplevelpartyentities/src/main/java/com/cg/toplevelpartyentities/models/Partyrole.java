package com.cg.toplevelpartyentities.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PARTYROLE")
public class Partyrole {
	@Id
	@Column(name="ROLETYPEID")
	private int roleTypeId;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonProperty("Party")
	@JoinColumn(name="PR_PARTYID", nullable = false)
	@JsonBackReference(value="party-partyrole")
	private Party party;

	public int getRoleTypeId() {
		return roleTypeId;
	}

	public void setRoleTypeId(int roleTypeId) {
		this.roleTypeId = roleTypeId;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

}

package com.cg.toplevelpartyentities.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="USERLOGIN")
public class Userlogin {
	@Id
	@Column(name="USERLOGINID")
	private String userLoginId;
	@Column(name="CURRENTPASSWORD")
	private String currentPassword;
	@Column(name="PASSWORDHINT")
	private String passwordHint;
	@Column(name="ISSYSTEMENABLED")
	private boolean isSystemEnabled;
	@Column(name="HASLOGGEDOUT")
	private boolean hasLoggedOut;
	@Column(name="REQUIREPASSWORDCHANGE")
	private boolean requirePasswordChange;
	@Column(name="LASTCURRENCYUOM")
	private int lastCurrencyUom;
	@Column(name="LASTLOCALE")
	@JsonFormat(pattern = "hh:mm:ss")
	private Time lastLocale;
	@Column(name="LASTTIMEZONE")
	private String lastTimeZone;
	@Column(name="DISABLEDDATETIME")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date disabledDateTime;
	@Column(name="SUCCESSIVEFAILEDLOGINS")
	private int sucessiveFailedLogins;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="USERLOGIN_PARTYID", nullable = false)
	@JsonBackReference(value="party-userlogin")
	private Party party;
	
	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public boolean isSystemEnabled() {
		return isSystemEnabled;
	}

	public void setSystemEnabled(boolean isSystemEnabled) {
		this.isSystemEnabled = isSystemEnabled;
	}

	public boolean isHasLoggedOut() {
		return hasLoggedOut;
	}

	public void setHasLoggedOut(boolean hasLoggedOut) {
		this.hasLoggedOut = hasLoggedOut;
	}

	public boolean isRequirePasswordChange() {
		return requirePasswordChange;
	}

	public void setRequirePasswordChange(boolean requirePasswordChange) {
		this.requirePasswordChange = requirePasswordChange;
	}

	public int getLastCurrencyUom() {
		return lastCurrencyUom;
	}

	public void setLastCurrencyUom(int lastCurrencyUom) {
		this.lastCurrencyUom = lastCurrencyUom;
	}

	public Time getLastLocale() {
		return lastLocale;
	}

	public void setLastLocale(Time lastLocale) {
		this.lastLocale = lastLocale;
	}

	public String getLastTimeZone() {
		return lastTimeZone;
	}

	public void setLastTimeZone(String lastTimeZone) {
		this.lastTimeZone = lastTimeZone;
	}

	public Date getDisabledDateTime() {
		return disabledDateTime;
	}

	public void setDisabledDateTime(Date disabledDateTime) {
		this.disabledDateTime = disabledDateTime;
	}

	public int getSucessiveFailedLogins() {
		return sucessiveFailedLogins;
	}

	public void setSucessiveFailedLogins(int sucessiveFailedLogins) {
		this.sucessiveFailedLogins = sucessiveFailedLogins;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}


}

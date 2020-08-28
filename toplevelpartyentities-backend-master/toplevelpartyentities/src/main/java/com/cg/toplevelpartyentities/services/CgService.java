package com.cg.toplevelpartyentities.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.toplevelpartyentities.models.Contactmech;
import com.cg.toplevelpartyentities.models.Party;
import com.cg.toplevelpartyentities.models.Partycontactmech;
import com.cg.toplevelpartyentities.models.Partygroup;
import com.cg.toplevelpartyentities.models.Partyrole;
import com.cg.toplevelpartyentities.models.Person;
import com.cg.toplevelpartyentities.models.Userlogin;
import com.cg.toplevelpartyentities.repos.ContactmechRepo;
import com.cg.toplevelpartyentities.repos.PartyRepository;
import com.cg.toplevelpartyentities.repos.PartycontactmechRepo;
import com.cg.toplevelpartyentities.repos.PartygroupRepo;
import com.cg.toplevelpartyentities.repos.PartyroleRepo;
import com.cg.toplevelpartyentities.repos.PersonRepo;
import com.cg.toplevelpartyentities.repos.UserloginRepo;


@Service
@Transactional
public class CgService {
	@Autowired
	PartyRepository partyrepo;
	@Autowired
	PersonRepo personrepo;
	@Autowired
	PartygroupRepo partygrouprepo;
	@Autowired
	UserloginRepo userloginrepo;
	@Autowired
	ContactmechRepo contactmechrepo;
	@Autowired
	PartycontactmechRepo partycontactmechrepo;
	@Autowired
	PartyroleRepo partyrolerepo;
	
	
	/*********All retriving requests**********/
	
	public List<Party> getPartyDetails(Party party){
		return (List<Party>) partyrepo.findAll();
		
	}
	
	public List<Partygroup> getPartyGroupDetails(Partygroup pg){
		return (List<Partygroup>) partygrouprepo.findAll();
		
	}
	
	public List<Person> getPersonDetails(Person person){
		return (List<Person>) personrepo.findAll();
		
	}
	
	public List<Userlogin> getUserLoginDetails(Userlogin ul){
		return (List<Userlogin>) userloginrepo.findAll();
		
	}
	
	public List<Contactmech> getContactmechDetails(Contactmech cm){
		return (List<Contactmech>) contactmechrepo.findAll();
		
	}
	
	public List<Partycontactmech> getPartycontactmechDetails(Partycontactmech pcm){
		return (List<Partycontactmech>) partycontactmechrepo.findAll();
		
	}
	
	public List<Partyrole> getPartyroleDetails(Partyrole pr){
		return (List<Partyrole>) partyrolerepo.findAll();
		
	}
	
	/*********All creating requests**********/
	
	public void addPartyDetails(Party party) { 
		partyrepo.save(party); 
		
	}
	
	public Optional<Partygroup> addPartyGroupDetails(int partyId,Partygroup pg) { 
		return partyrepo.findById(partyId).map(party -> {
			pg.setParty(party);
			return partygrouprepo.save(pg);
		}); 
		
	}
	
	public Optional<Person> addPersonDetails(int partyId,Person person) { 
		return partyrepo.findById(partyId).map(party -> {
			person.setParty(party);
			return personrepo.save(person);
		});  
		
	}
	
	public Optional<Userlogin> addUserLoginDetails(int partyId,Userlogin ul) { 
		return partyrepo.findById(partyId).map(party -> {
			ul.setParty(party);
			return userloginrepo.save(ul);
		}); 
		
	}
	
	public Optional<Partycontactmech> addPartycontactmechDetails(int partyId,Partycontactmech pcm) { 
		return partyrepo.findById(partyId).map(party -> {
			pcm.setParty(party);
			return partycontactmechrepo.save(pcm);
		}); 
		
	}
	
	public Optional<Contactmech> addContactmechDetails(int contactMechId,Contactmech cm) { 
		return partycontactmechrepo.findById(contactMechId).map(pcm -> {
			cm.setPartycontactmech(pcm);
			return contactmechrepo.save(cm);
		}); 
		
	}
	
	/*********All deleting requests **********/
	
	
	
	public void deleteParty(int partyId) {
		   partyrepo.deleteById(partyId);
	}
	
	
	public void deletePartycontactmech(int contactMechId) {
		partycontactmechrepo.deleteById(contactMechId);
	}
	
	public void deleteContactmech(int contactMechTypeId) {
		contactmechrepo.deleteById(contactMechTypeId);
	}
	
	public void deletePerson(String firstName) {
		 personrepo.deleteByString(firstName);
	}
	
	public void deleteUserlogin(String userLoginId) {
		userloginrepo.deleteByString(userLoginId);
	}
	
	public void deletePartygroup(String groupNameLocal) {
		partygrouprepo.deleteByString(groupNameLocal);
	}
	
	
	 
	/*********All updating requests **********/
	
	public Optional<Object> updateParty(int partyId, Party p) {
		return partyrepo.findById(partyId).map(party -> {
			party.setPartyTypeId(p.getPartyTypeId());
			party.setExternalId(p.getExternalId());
			party.setCurrencyUomId(p.getCurrencyUomId());
			party.setDescription(p.getDescription());
			party.setStatusId(p.getStatusId());
			return partyrepo.save(p);
		});
	}
	
	public Optional<Object> updatePartycontactmech
	(int partyId, int contactMechId,Partycontactmech pcm){
		return partycontactmechrepo.findById(contactMechId).map(cm -> {
            cm.setFromDate(pcm.getFromDate());
            cm.setThruDate(pcm.getThruDate());
            cm.setRoleTypeId(pcm.getRoleTypeId());
            cm.setAllowSocialization(pcm.isAllowSocialization());
            cm.setExtension(pcm.isExtension());
            cm.setVerified(pcm.isVerified());
            cm.setYearsWithContactMech(pcm.getYearsWithContactMech());
            cm.setMonthsWithContactMech(pcm.getMonthsWithContactMech());
            return partycontactmechrepo.save(cm);
        });
	}
	
	public Optional<Object> updateContactmech
	(int contactMechId,int contactMechTypeId,Contactmech cm){
		return contactmechrepo.findById(contactMechTypeId).map(m -> {
			m.setInfoString(cm.getInfoString());
			return contactmechrepo.save(m);
		});
	}
	
	public Optional<Object> updateUserlogin
	(int partyId, String userLoginId,Userlogin ul){
		return userloginrepo.findByString(userLoginId).map(u -> {
           u.setCurrentPassword(ul.getCurrentPassword());
           u.setPasswordHint(ul.getPasswordHint());
           u.setSystemEnabled(ul.isSystemEnabled());
           u.setHasLoggedOut(ul.isHasLoggedOut());
           u.setRequirePasswordChange(ul.isRequirePasswordChange());
           u.setLastCurrencyUom(ul.getLastCurrencyUom());	
           u.setLastLocale(ul.getLastLocale());
           u.setLastTimeZone(ul.getLastTimeZone());
           u.setDisabledDateTime(ul.getDisabledDateTime());
           u.setSucessiveFailedLogins(ul.getSucessiveFailedLogins());
           return userloginrepo.save(u);
		});
		
	}
	
	public Optional<Object> updatePerson
	(int partyId, String firstName,Person p){
		return personrepo.findByString(firstName).map(pp -> {
			pp.setMiddleName(p.getMiddleName());
			pp.setLastName(p.getLastName());
			pp.setPersonalTitle(p.getPersonalTitle());
			pp.setSuffix(p.getSuffix());
			pp.setGender(p.getGender());
			pp.setBirthDate(p.getBirthDate());
			pp.setMaritalStatus(p.getMaritalStatus());
			return personrepo.save(pp);
		});
	}
	
	public Optional<Object> updatePartygroup
	(int partyId, String groupNameLocal,Partygroup pg){
		return partygrouprepo.findByString(groupNameLocal).map(p -> {
			p.setGroupName(pg.getGroupName());
			p.setOfficesiteName(pg.getOfficesiteName());
			p.setComments(pg.getComments());
			p.setLogoImageUrl(pg.getLogoImageUrl());
			return partygrouprepo.save(p);
		});
	}
	
}

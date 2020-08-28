
package com.cg.toplevelpartyentities.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.toplevelpartyentities.models.Contactmech;
import com.cg.toplevelpartyentities.models.Party;
import com.cg.toplevelpartyentities.models.Partycontactmech;
import com.cg.toplevelpartyentities.models.Partygroup;
import com.cg.toplevelpartyentities.models.Partyrole;
import com.cg.toplevelpartyentities.models.Person;
import com.cg.toplevelpartyentities.models.Userlogin;
import com.cg.toplevelpartyentities.services.CgService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CgController {
	@Autowired
	CgService service;
	
	
	/********All retriving requests******/
	
	@GetMapping("/party")
	public List<Party> getPartyDetails(Party party ){
		return service.getPartyDetails(party);
		
	}
	
	@GetMapping("/partygroup")
	public List<Partygroup> getPartyGroupDetails(Partygroup pg ){
		return service.getPartyGroupDetails(pg);
		
	}
	
	@GetMapping("/person")
	public List<Person> getPersonDetails(Person person ){
		return service.getPersonDetails(person);
		
	}

	@GetMapping("/userlogin")
	public List<Userlogin> getUserLoginDetails(Userlogin ul ){
		return service.getUserLoginDetails(ul);
		
	}
	
	@GetMapping("/contactmech")
	public List<Contactmech> getContactmechDetails(Contactmech cm ){
		return service.getContactmechDetails(cm);
		
	}
	
	@GetMapping("/partycontactmech")
	public List<Partycontactmech> getPartycontactmechDetails(Partycontactmech pcm ){
		return service.getPartycontactmechDetails(pcm);
		
	}
	
	@GetMapping("/partyrole")
	public List<Partyrole> getPartyroleDetails(Partyrole pr ){
		return service.getPartyroleDetails(pr);
		
	}
	
	/*********All creating requests**********/
	//@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addparty") 
	private  void addItem(@RequestBody Party party) {
		  service.addPartyDetails(party); 
		   
		  
	}
	
	@PostMapping("/party/{partyId}/addpartygroup")
	public Optional<Partygroup> createPartyGroup(@PathVariable(value="partyId") int partyId,
			@Valid @RequestBody Partygroup partygroup) {
		return service.addPartyGroupDetails(partyId, partygroup);
	}
	
	@PostMapping("/party/{partyId}/addperson")
	public Optional<Person> createPerson(@PathVariable(value="partyId") int partyId,
			@Valid @RequestBody Person person) {
		return service.addPersonDetails(partyId, person);
	}
	
	
	
	@PostMapping("/party/{partyId}/adduserlogin")
	public Optional<Userlogin> createUserlogin(@PathVariable(value="partyId") int partyId,
			@Valid @RequestBody Userlogin ul) {
		return service.addUserLoginDetails(partyId, ul);
	}
	
	@PostMapping("/party/{partyId}/addpartycontactmech")
	public Optional<Partycontactmech> createPartycontactmech(@PathVariable(value="partyId") int partyId,
			@Valid @RequestBody Partycontactmech pcm) {
		return service.addPartycontactmechDetails(partyId, pcm);
	}
	
	@PostMapping("/partycontactmech/{contactMechId}/addcontactmech")
	public Optional<Contactmech> createContactmech(@PathVariable(value="contactMechId") int contactMechId,
			@Valid @RequestBody Contactmech cm) {
		return service.addContactmechDetails(contactMechId, cm);
	}

	
	
	/*********All deleting requests**********/
	
	@DeleteMapping("/deleteparty/{partyId}")
	private void deleteItem(@PathVariable("partyId") int partyId) { 
		service.deleteParty(partyId); 
		
		
	}

	
	@DeleteMapping("/deletepcm/{contactMechId}")
	private void deletePartycontactmech(@PathVariable("contactMechId") int contactMechId) { 
		service.deletePartycontactmech(contactMechId); 
		
		
	}
	
	
	@DeleteMapping("/deletecm/{contactMechTypeId}")
	private void deleteContactmech(@PathVariable("contactMechTypeId") int contactMechTypeId) { 
		service.deleteContactmech(contactMechTypeId); 
		
		
	}
	
	@DeleteMapping("/deleteperson/{firstName}")
	private void deletePerson(@PathVariable("firstName") String firstName) { 
		service.deletePerson(firstName); 
		
	}
	
	@DeleteMapping("/deleteuserlogin/{userLoginId}")
	private void deleteUserlogin(@PathVariable("userLoginId") String userLoginId) { 
		service.deleteUserlogin(userLoginId); 
		
	}
	
	@DeleteMapping("/deletepartygroup/{groupNameLocal}")
	private void deletePartygroup(@PathVariable("groupNameLocal") String groupNameLocal) { 
		service.deletePartygroup(groupNameLocal); 
		
	}
	
	
	/*********All updating requests **********/
	
    @PutMapping("/updateparty/{partyId}")
	public ResponseEntity<String> updateParty(@PathVariable (value = "partyId") int partyId,
							@Valid @RequestBody Party p) {
		service.updateParty(partyId, p);
		return new ResponseEntity<String>("Updated Successfully"+ partyId,HttpStatus.ACCEPTED);
	}
    
    @PutMapping("/party/{partyId}/updatepcm/{contactMechId}")
    public ResponseEntity<String> updatePartycontactmech(
    		@PathVariable (value = "partyId") int partyId,
            @PathVariable (value = "contactMechId") int contactMechId,
            @Valid @RequestBody Partycontactmech pcm) {
    	service.updatePartycontactmech(partyId, contactMechId, pcm);
    	return new ResponseEntity<String>("Updated Successfully"+ partyId,HttpStatus.ACCEPTED);
    	
    }
    
    @PutMapping("/pcm/{contactMechId}/updatecm/{contactMechTypeId}")
    public ResponseEntity<String> updateContactmech(
    		@PathVariable (value = "contactMechId") int contactMechId,
            @PathVariable (value = "contactMechTypeId") int contactMechTypeId,
            @Valid @RequestBody Contactmech cm) {
    	service.updateContactmech(contactMechId, contactMechTypeId, cm);
    	return new ResponseEntity<String>("Updated Successfully"+ contactMechId,HttpStatus.ACCEPTED);
    	
    }
    
    @PutMapping("/party/{partyId}/updatepuserlogin/{userLoginId}")
    public ResponseEntity<String> updateUserlogin(
    		@PathVariable (value = "partyId") int partyId,
            @PathVariable (value = "userLoginId") String userLoginId,
            @Valid @RequestBody Userlogin ul) {
    	service.updateUserlogin(partyId, userLoginId, ul);
    	return new ResponseEntity<String>("Updated Successfully"+" "+ partyId,HttpStatus.ACCEPTED);
    	
    }
    
    @PutMapping("/party/{partyId}/updateperson/{firstName}")
    public ResponseEntity<String> updatePerson(
    		@PathVariable (value = "partyId") int partyId,
            @PathVariable (value = "firstName") String firstName,
            @Valid @RequestBody Person p) {
    	service.updatePerson(partyId, firstName, p);
    	return new ResponseEntity<String>("Updated Successfully"+" "+ partyId,HttpStatus.ACCEPTED);
    	
    }
    
    @PutMapping("/party/{partyId}/updatepartygroup/{groupNameLocal}")
    public ResponseEntity<String> updatePartygroup(
    		@PathVariable (value = "partyId") int partyId,
            @PathVariable (value = "groupNameLocal") String groupNameLocal,
            @Valid @RequestBody Partygroup pg) {
    	service.updatePartygroup(partyId, groupNameLocal, pg);
    	return new ResponseEntity<String>("Updated Successfully"+" "+ partyId,HttpStatus.ACCEPTED);
    	
    }
}	 


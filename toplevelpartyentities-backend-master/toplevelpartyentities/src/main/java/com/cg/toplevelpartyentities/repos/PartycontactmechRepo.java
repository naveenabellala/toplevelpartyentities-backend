package com.cg.toplevelpartyentities.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.cg.toplevelpartyentities.models.Partycontactmech;


public interface PartycontactmechRepo extends JpaRepository <Partycontactmech, Integer>{

	@Query("from Partycontactmech where contactMechId=:o and PCM_PARTYID=:i")
	Optional<Partycontactmech> findByIdAndpartyId(@Param("o")int contactMechId,@Param("i") int partyId);
	
	
	

}

package com.cg.toplevelpartyentities.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.toplevelpartyentities.models.Contactmech;


public interface ContactmechRepo extends JpaRepository <Contactmech, Integer>{

	@Query("from Contactmech where contactMechTypeId=:o and PCM_CONTACTMECHID=:i")
	Optional<Contactmech> findByIdAndcontactMechId(@Param("o")int contactMechTypeId, @Param("i")int contactMechId);

}

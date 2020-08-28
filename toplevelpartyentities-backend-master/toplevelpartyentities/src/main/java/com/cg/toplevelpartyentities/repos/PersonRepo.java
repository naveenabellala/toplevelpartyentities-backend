package com.cg.toplevelpartyentities.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cg.toplevelpartyentities.models.Partygroup;
import com.cg.toplevelpartyentities.models.Person;

public interface PersonRepo extends JpaRepository <Person, String> {

	@Query("from Person where firstName=:o and PERSON_PARTYID=:i")
	Optional<Person> findByStringAndpartyId(@Param("o")String firstName,@Param("i") int partyId);
	
	@Query("from Person where firstName=:p")
	Optional<Person> findByString(@Param("p")String firstName);
	
	@Modifying	
	@Query("delete from Person per where per.firstName=:fname")
	void deleteByString(@Param("fname")String firstName);

}

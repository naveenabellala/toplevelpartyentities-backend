package com.cg.toplevelpartyentities.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.toplevelpartyentities.models.Partygroup;

@Repository
public interface PartygroupRepo extends JpaRepository <Partygroup, String> {

	
	@Query("from Partygroup where groupNameLocal=:gnl and GROUP_PARTYID=:i")
	Optional<Partygroup> findByStringAndpartyId(@Param("gnl")String groupNameLocal,@Param("i") int partyId);
	
	@Query("from Partygroup where groupNameLocal=:gnl")
	Optional<Partygroup> findByString(@Param("gnl")String groupNameLocal);
	
	@Modifying	
	@Query("delete from Partygroup pg where pg.groupNameLocal=:gnl")
	void deleteByString(@Param("gnl")String groupNameLocal);

	
}

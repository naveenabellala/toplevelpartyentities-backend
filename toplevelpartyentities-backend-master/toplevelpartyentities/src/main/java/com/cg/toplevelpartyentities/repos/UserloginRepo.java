package com.cg.toplevelpartyentities.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.toplevelpartyentities.models.Partygroup;
import com.cg.toplevelpartyentities.models.Userlogin;

public interface UserloginRepo extends JpaRepository <Userlogin, String>{

	@Query("from Userlogin where userLoginId=:o and USERLOGIN_PARTYID=:i")
	Optional<Userlogin> findByStringAndpartyId(@Param("o") String userLoginId,@Param("i") int partyId);
	
	@Query("from Userlogin where userLoginId=:o")
	Optional<Userlogin> findByString(@Param("o")String userLoginId);

	@Modifying	
	@Query("delete from Userlogin ul where ul.userLoginId=:id")
	void deleteByString(@Param("id")String userLoginId);

}

package com.cg.toplevelpartyentities.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.toplevelpartyentities.models.Party;

public interface PartyRepository extends JpaRepository<Party, Integer>{

}

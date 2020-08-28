package com.cg.toplevelpartyentities.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.toplevelpartyentities.models.Partyrole;
@Repository
public interface PartyroleRepo extends JpaRepository <Partyrole, Integer>{

}

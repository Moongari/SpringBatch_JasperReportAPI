package com.moon.batchApi.personspringBatchApi.Dao;

import com.moon.batchApi.personspringBatchApi.model.Personn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonnRepository extends JpaRepository<Personn,Integer> {

    List<Personn> findAll();


}

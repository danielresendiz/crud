package com.indra.bbva.ejerciciocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.ejerciciocrud.models.regionsEntity;

@Repository
public interface regionsRepository extends JpaRepository<regionsEntity,Integer> {

}

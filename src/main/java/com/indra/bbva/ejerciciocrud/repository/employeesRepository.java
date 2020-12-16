package com.indra.bbva.ejerciciocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.ejerciciocrud.models.employeesEntity;

@Repository
public interface employeesRepository extends JpaRepository<employeesEntity,Integer>{

}

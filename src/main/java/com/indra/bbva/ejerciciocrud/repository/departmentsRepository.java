package com.indra.bbva.ejerciciocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.ejerciciocrud.models.departmentsEntity;

@Repository
public interface departmentsRepository extends JpaRepository<departmentsEntity,Integer> {

}

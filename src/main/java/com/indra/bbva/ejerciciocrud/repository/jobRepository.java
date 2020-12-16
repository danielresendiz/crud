package com.indra.bbva.ejerciciocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.ejerciciocrud.models.jobEntity;

@Repository
public interface jobRepository extends JpaRepository<jobEntity,String> {

}

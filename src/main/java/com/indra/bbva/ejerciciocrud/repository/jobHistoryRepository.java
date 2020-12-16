package com.indra.bbva.ejerciciocrud.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.ejerciciocrud.models.jobHistoryEntity;

@Repository
public interface jobHistoryRepository extends JpaRepository<jobHistoryEntity,Date>{

}

package com.puzan.springhandson.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.puzan.springhandson.model.SupportingDoc;

@Repository
public interface SupportingDocRepository extends JpaRepository<SupportingDoc, Long> {
    Page<SupportingDoc> findByEnrollmentId(Long enrollmentId, Pageable pageable);
    Optional<SupportingDoc> findByIdAndEnrollmentId(Long id, Long enrollmentId);
}

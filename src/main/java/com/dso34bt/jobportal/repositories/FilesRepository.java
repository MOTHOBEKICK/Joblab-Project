package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilesRepository extends JpaRepository<Files, Long> {

    boolean existsByCandidate_Id(Long id);
    Optional<Files> findByCandidateId(long id);
}

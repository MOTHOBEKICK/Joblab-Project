package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    Optional<Experience> findByCandidateId(long id);

    boolean existsByCandidate_Id(long id);

    void deleteByCandidateId(long id);
}

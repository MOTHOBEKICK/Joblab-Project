package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.Qualifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QualificationsRepository extends JpaRepository<Qualifications,Long> {
    Optional<Qualifications> findByCandidateId(long id);

    boolean existsByCandidate_Id(long id);

    void deleteByCandidateId(long id);
}

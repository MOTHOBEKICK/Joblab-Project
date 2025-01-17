package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.JobPostAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPostAssessmentRepository extends JpaRepository<JobPostAssessment,Long> {
    Optional<JobPostAssessment> findByJobPostId(long id);
    boolean existsByJobPostId(long id);
    void deleteByJobPostId(long id);
}

package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.AssessmentResults;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssessmentResultsRepository extends JpaRepository<AssessmentResults,Long> {
    Optional<AssessmentResults> findByCandidateIdAndJobPostAssessmentId(long candidateId, long assessmentId);
    void deleteByCandidateIdAndJobPostAssessmentId(long candidateId, long assessmentId);
    List<AssessmentResults> findByJobPostAssessmentId(long id);
    boolean existsByCandidate_Id(long id);
}

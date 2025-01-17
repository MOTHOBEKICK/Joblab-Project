package com.dso34bt.jobportal.services;

import com.dso34bt.jobportal.model.Qualifications;
import com.dso34bt.jobportal.repositories.QualificationsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QualificationService {
    private final QualificationsRepository repository;

    public QualificationService(QualificationsRepository repository) {
        this.repository = repository;
    }

    public Optional<Qualifications> getQualificationByCandidateId(long id){
        return repository.findByCandidateId(id);
    }

    public boolean existsByCandidateId(long id){
        return repository.existsByCandidate_Id(id);
    }

    public boolean saveQualification(Qualifications qualifications){
        repository.save(qualifications);

        return repository.existsByCandidate_Id(qualifications.getCandidate().getId());
    }

    public boolean deleteQualification(long id){
        repository.deleteByCandidateId(id);

        return repository.existsByCandidate_Id(id);
    }
}

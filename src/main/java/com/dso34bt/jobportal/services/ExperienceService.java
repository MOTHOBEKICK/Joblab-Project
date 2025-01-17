package com.dso34bt.jobportal.services;

import com.dso34bt.jobportal.model.Experience;
import com.dso34bt.jobportal.repositories.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceService {
    private final ExperienceRepository repository;

    public ExperienceService(ExperienceRepository repository) {
        this.repository = repository;
    }

    public Optional<Experience> getExperienceByCandidateID(long id){
        return repository.findByCandidateId(id);
    }

    public boolean existsByCandidateID(long id){
        return repository.existsByCandidate_Id(id);
    }

    public boolean saveExperience(Experience experience){
        repository.save(experience);

        return repository.existsByCandidate_Id(experience.getCandidate().getId());
    }

    public boolean deleteExperience(long id){
        repository.deleteById(id);

        return repository.existsByCandidate_Id(id);
    }
}

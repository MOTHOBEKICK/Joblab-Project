package com.dso34bt.jobportal.services;

import com.dso34bt.jobportal.model.Candidate;
import com.dso34bt.jobportal.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private final CandidateRepository repository;

    public CandidateService(CandidateRepository repository) {
        this.repository = repository;
    }

    public boolean candidateExists(String email){
        return repository.existsByCandidateAccountEmail(email);
    }

    public boolean saveCandidate(Candidate candidate){
        repository.save(candidate);

        return repository.existsByCandidateAccountEmail(candidate.getCandidateAccount().getEmail());
    }

    public void saveAll(List<Candidate> candidates){
        repository.saveAll(candidates);
    }

    public boolean deleteCandidateByEmail(String email){
        repository.deleteByCandidateAccountEmail(email);

        return repository.existsByCandidateAccountEmail(email);
    }

    public List<Candidate> getCandidates(){
        return repository.findAll();
    }

    public Optional<Candidate> getCandidateByEmail(String email){
        return repository.findByCandidateAccountEmail(email);
    }
}

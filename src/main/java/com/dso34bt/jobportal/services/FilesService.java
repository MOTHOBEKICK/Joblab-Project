package com.dso34bt.jobportal.services;

import com.dso34bt.jobportal.model.Files;
import com.dso34bt.jobportal.repositories.FilesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilesService {

    private final FilesRepository repository;

    public FilesService(FilesRepository repository) {
        this.repository = repository;
    }

    public boolean existsByCandidate_Id(long candidateId){
        return repository.existsByCandidate_Id(candidateId);
    }

    public Optional<Files> getFilesByCandidate_Id(long candidateId){
        return repository.findByCandidateId(candidateId);
    }

    public boolean saveFiles(Files files){
        repository.save(files);

        return repository.existsById(files.getId());
    }

    public boolean deleteFiles(long id){
        repository.deleteById(id);

        return repository.existsById(id);
    }
}

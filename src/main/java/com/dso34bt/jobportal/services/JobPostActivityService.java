package com.dso34bt.jobportal.services;

import com.dso34bt.jobportal.model.JobPostActivity;
import com.dso34bt.jobportal.repositories.JobPostActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostActivityService {
    private final JobPostActivityRepository repository;

    public JobPostActivityService(JobPostActivityRepository repository) {
        this.repository = repository;
    }

    public List<JobPostActivity> getByJobPostId(long id){
        return repository.findByJobPostId(id);
    }

    public List<JobPostActivity> getByCandidateId(long id){
        return repository.findByCandidateId(id);
    }
    public Optional<JobPostActivity> getById(long id){
        return repository.findById(id);
    }

    public List<JobPostActivity> getJobPostActivities(){
        return repository.findAll();
    }

    public boolean saveJobPostActivity(JobPostActivity jobPostActivity){
        repository.save(jobPostActivity);

        return repository.existsByCandidate_Id(jobPostActivity.getCandidate().getId());
    }

    public boolean deleteByCandidateIdAndJobPostId(long candidateId, long jobPostId){
        repository.deleteByCandidateIdAndJobPostId(candidateId, jobPostId);

        return repository.existsByCandidate_Id(candidateId);
    }
}

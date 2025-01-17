package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost,Long> {
    List<JobPost> findByStaffId(long id);
}

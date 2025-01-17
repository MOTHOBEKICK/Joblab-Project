package com.dso34bt.jobportal.repositories;

import com.dso34bt.jobportal.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findByStaffAccountEmail(String email);
    boolean existsByStaffAccountEmail(String email);
}

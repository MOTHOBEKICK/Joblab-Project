package com.dso34bt.jobportal.bootstrap;

import com.dso34bt.jobportal.model.Candidate;
import com.dso34bt.jobportal.model.StaffAccount;
import com.dso34bt.jobportal.services.StaffAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {
    private final StaffAccountService accountService;

    public Runner(StaffAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
    }


}

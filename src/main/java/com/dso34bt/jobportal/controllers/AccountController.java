package com.dso34bt.jobportal.controllers;

import com.dso34bt.jobportal.model.CandidateAccount;
import com.dso34bt.jobportal.model.StaffAccount;
import com.dso34bt.jobportal.services.CandidateAccountService;
import com.dso34bt.jobportal.services.StaffAccountService;
import com.dso34bt.jobportal.utilities.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class AccountController {
    private final CandidateAccountService candidateAccountService;
    private final StaffAccountService staffAccountService;

    public AccountController(CandidateAccountService candidateAccountService, StaffAccountService staffAccountService) {
        this.candidateAccountService = candidateAccountService;
        this.staffAccountService = staffAccountService;
    }

    @GetMapping("login")
    public String candidateLogin(Model model) {
        model.addAttribute("user", new CandidateAccount());
        model.addAttribute("userSignup", new CandidateAccount());
        return "login";
    }

    @PostMapping("login")
    public String verifyCandidate(@ModelAttribute CandidateAccount user,
                                  Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }

        if (!candidateAccountService.existsByEmail(user.getEmail())) {
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }

        Optional<CandidateAccount> userDetails = candidateAccountService.getUserAccountByEmail(user.getEmail());

        if (!userDetails.get().getPassword().equals(user.getPassword())) {
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }

        // if details are verified and true, session user will be set and redirect to apply
        Session.setCandidateAccount(userDetails.get());
        return "redirect:/apply";
    }

    @PostMapping("signup")
    public String candidateSignup(@ModelAttribute CandidateAccount user,
                                  Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }
        CandidateAccount account = user;

        account.setId(candidateAccountService.getLastId() + 1);
        account.setEmailNotificationActive(false);
        account.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));

        System.out.println("account: " + account);

        if (!candidateAccountService.saveCandidateAccount(account)){
            model.addAttribute("user", new CandidateAccount());
            return "login";
        }

        return "login";
    }

    @GetMapping("login-staff")
    public String staffLogin(Model model) {
        model.addAttribute("user", new CandidateAccount());
        return "login-staff";
    }

    @PostMapping("login-staff")
    public String verifyStaff(@ModelAttribute StaffAccount user, Model model, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", new StaffAccount());
            return "login-staff";
        }

        if (!staffAccountService.existsByEmail(user.getEmail())) {
            model.addAttribute("user", new StaffAccount());

            return "login-staff";
        }

        Optional<StaffAccount> userDetails = staffAccountService.getUserAccountByEmail(user.getEmail());

        if (!userDetails.get().getPassword().equals(user.getPassword())) {
            model.addAttribute("user", new StaffAccount());

            return "login-staff";
        }

        // if details are verified and true, session user will be set and redirect to dashboard
        Session.setStaffAccount(userDetails.get());
        return "redirect:/job-post";

    }
}

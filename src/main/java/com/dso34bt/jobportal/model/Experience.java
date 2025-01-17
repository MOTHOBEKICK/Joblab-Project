package com.dso34bt.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
public class Experience implements Serializable {
    @Id
    @SequenceGenerator(
            name = "experience_sequence",
            sequenceName = "experience_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "experience_sequence"
    )
    private Long id;

    @NotNull(message = "Current Job Status cannot be null")
    @Column(length = 10)
    private boolean title;

    @NotNull(message = "Job Title cannot be null")
    @Column(length = 100, name = "job_title")
    private String jobTitle;

    @NotNull(message = "Description cannot be null")
    @Column(length = 5000)
    private String description;

    @NotNull(message = "Company Name cannot be null")
    @Column(length = 100, name = "company_name")
    private String companyName;

    @NotNull(message = "Start Date cannot be null")
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "End Date cannot be null")
    @Column(name = "end_date")
    private Date endDate;

    @NotNull(message = "Notice Period cannot be null")
    @Column(name = "notice_period")
    private String noticePeriod;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTitle() {
        return title;
    }

    public void setTitle(boolean title) {
        this.title = title;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", title=" + title +
                ", jobTitle='" + jobTitle + '\'' +
                ", description='" + description + '\'' +
                ", companyName='" + companyName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", noticePeriod='" + noticePeriod + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}

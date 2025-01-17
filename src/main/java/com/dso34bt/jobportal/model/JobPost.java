package com.dso34bt.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Entity
@Table(name = "job_post")
public class JobPost implements Serializable {
    @Id
    @SequenceGenerator(
            name = "job_post_sequence",
            sequenceName = "job_post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_post_sequence"
    )
    private Long id;

    @NotNull(message = "Job Title cannot be null")
    @Column(length = 100)
    private String title;

    @NotNull(message = "Job Type cannot be null")
    @Column(length = 50)
    private String type;

    @NotNull(message = "Job Purpose cannot be null")
    @Column(length = 5000)
    private String purpose;

    @NotNull(message = "Job Description cannot be null")
    @Column(length = 5000)
    private String description;

    @NotNull(message = "Qualification cannot be null")
    @Column(length = 1500)
    private String qualification;

    @NotNull(message = "Requirements cannot be null")
    @Column(length = 5000)
    private String requirements;

    @NotNull(message = "Responsibilities cannot be null")
    @Column(length = 5000)
    private String responsibilities;

    @NotNull(message = "Location cannot be null")
    @Column(length = 255)
    private String location;

    @NotNull(message = "Created Date cannot be null")
    @Column(name = "created_date")
    private Date createdDate;

    @NotNull(message = "Closing Date cannot be null")
    @Column(name = "closing_date")
    private Date closingDate;

    @NotNull(message = "Assessment Required cannot be null")
    @Column(name = "is_assessment_required")
    private boolean assessmentRequired;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public boolean isAssessmentRequired() {
        return assessmentRequired;
    }

    public void setAssessmentRequired(boolean assessmentRequired) {
        this.assessmentRequired = assessmentRequired;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<String> getQualificationList() {
        StringTokenizer tokenizer = new StringTokenizer(qualification, ";");

        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }

        return list;
    }

    public List<String> getRequirementsList() {
        StringTokenizer tokenizer = new StringTokenizer(requirements, ";");

        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }

        return list;
    }

    public List<String> getResponsibilitiesList() {
        StringTokenizer tokenizer = new StringTokenizer(responsibilities, ";");

        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }

        return list;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", purpose='" + purpose + '\'' +
                ", description='" + description + '\'' +
                ", qualification='" + qualification + '\'' +
                ", requirements='" + requirements + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", location='" + location + '\'' +
                ", createdDate=" + createdDate +
                ", closingDate=" + closingDate +
                ", assessmentRequired=" + assessmentRequired +
                ", staff=" + staff +
                '}';
    }
}

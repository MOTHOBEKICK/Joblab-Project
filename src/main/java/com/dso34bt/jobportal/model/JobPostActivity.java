package com.dso34bt.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "job_post_activity")
public class JobPostActivity implements Serializable {
    @Id
    @SequenceGenerator(
            name = "job_post_activity_sequence",
            sequenceName = "job_post_activity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_post_activity_sequence"
    )
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_post_id", referencedColumnName = "id")
    private JobPost jobPost;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @NotNull(message = "Apply Date cannot be null")
    @Column(name = "apply_date")
    private Date date;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobPostActivity{" +
                "id=" + id +
                ", jobPost=" + jobPost +
                ", candidate=" + candidate +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}

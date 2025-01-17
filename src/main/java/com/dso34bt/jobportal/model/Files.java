package com.dso34bt.jobportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table
public class Files implements Serializable {
    @Id
    @SequenceGenerator(
            name = "files_sequence",
            sequenceName = "files_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "files_sequence"
    )
    private Long id;

    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] cv;

    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] transcripts;

    @Lob
    @Column(columnDefinition="BLOB", name = "matric_results")
    private byte[] matricResults;

    @Lob
    @Column(columnDefinition="BLOB", name = "id_copy")
    private byte[] idCopy;

    @Lob
    @Column(columnDefinition="BLOB", name = "police_clearance")
    private byte[] policeClearance;

    @Lob
    @Column(columnDefinition="BLOB", name = "recommendation_letter")
    private byte[] recommendationLetter;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    public Files() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(byte[] transcripts) {
        this.transcripts = transcripts;
    }

    public byte[] getMatricResults() {
        return matricResults;
    }

    public void setMatricResults(byte[] matricResults) {
        this.matricResults = matricResults;
    }

    public byte[] getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(byte[] idCopy) {
        this.idCopy = idCopy;
    }

    public byte[] getPoliceClearance() {
        return policeClearance;
    }

    public void setPoliceClearance(byte[] policeClearance) {
        this.policeClearance = policeClearance;
    }

    public byte[] getRecommendationLetter() {
        return recommendationLetter;
    }

    public void setRecommendationLetter(byte[] recommendationLetter) {
        this.recommendationLetter = recommendationLetter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", cv=" + Arrays.toString(cv) +
                ", transcripts=" + Arrays.toString(transcripts) +
                ", matricResults=" + Arrays.toString(matricResults) +
                ", idCopy=" + Arrays.toString(idCopy) +
                ", policeClearance=" + Arrays.toString(policeClearance) +
                ", recommendationLetter=" + Arrays.toString(recommendationLetter) +
                ", candidate=" + candidate +
                '}';
    }
}

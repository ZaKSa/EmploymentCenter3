package com.company.employmentcenter3.entity;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
public class SuitableProfessions {
    //@JmixGeneratedValue
    @JmixId
    private UUID suitableProfessionsId;

    @JmixProperty(mandatory = true)
    @NotNull
    private String nameOfEmployer;

    @JmixProperty(mandatory = true)
    @NotNull
    private String professions;

    @JmixProperty(mandatory = true)
    @NotNull
    private String post;

    @JmixProperty(mandatory = true)
    @NotNull
    private Integer salary;

    @JmixProperty(mandatory = true)
    @NotNull
    private Double bet;

    @JmixProperty(mandatory = true)
    @NotNull
    private LocalDate dateOfVacancyRegistration;

    public String getProfessions() {
        return professions;
    }

    public void setProfessions(String professions) {
        this.professions = professions;
    }

    public String getNameOfEmployer() {
        return nameOfEmployer;
    }

    public void setNameOfEmployer(String nameOfEmployer) {
        this.nameOfEmployer = nameOfEmployer;
    }

    public LocalDate getDateOfVacancyRegistration() {
        return dateOfVacancyRegistration;
    }

    public void setDateOfVacancyRegistration(LocalDate dateOfVacancyRegistration) {
        this.dateOfVacancyRegistration = dateOfVacancyRegistration;
    }

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public UUID getSuitableProfessionsId() {
        return suitableProfessionsId;
    }

    public UUID getId() {
        return suitableProfessionsId;
    }

    public void setSuitableProfessionsId(UUID id) {
        this.suitableProfessionsId = id;
    }
}
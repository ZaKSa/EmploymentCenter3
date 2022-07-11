package com.company.employmentcenter3.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "VACANCY")
@Entity
public class Vacancy {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "POST", nullable = false)
    @NotNull
    private String post;

    @Positive
    @Column(name = "SALARY", nullable = false)
    @NotNull
    private Integer salary;

    @PositiveOrZero
    @Column(name = "BET", nullable = false)
    @NotNull
    private Double bet;

    @Column(name = "DATE_OF_VACANCY_REGISTRATION", nullable = false)
    @NotNull
    private LocalDate dateOfVacancyRegistration;

    @Column(name = "NAME_OF_EMPLOYER", nullable = false)
    @NotNull
    private String nameOfEmployer;

    @Column(name = "PROFESSIONS", nullable = false)
    @NotNull
    private String professions;

    @JoinTable(name = "EMPLOYMENT_CENTER_VACANCY_LINK",
            joinColumns = @JoinColumn(name = "VACANCY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYMENT_CENTER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<EmploymentCenter> employmentCenters;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "vacancy")
    private Citizen citizen;

    @Column(name = "IS_SELECTED")
    private Boolean isSelected;

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public LocalDate getDateOfVacancyRegistration() {
        return dateOfVacancyRegistration;
    }

    public void setDateOfVacancyRegistration(LocalDate dateOfVacancyRegistration) {
        this.dateOfVacancyRegistration = dateOfVacancyRegistration;
    }

    public List<EmploymentCenter> getEmploymentCenters() {
        return employmentCenters;
    }

    public void setEmploymentCenters(List<EmploymentCenter> employmentCenters) {
        this.employmentCenters = employmentCenters;
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
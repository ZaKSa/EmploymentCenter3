package com.company.employmentcenter3.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "EMPLOYMENT_CENTER")
@Entity
public class EmploymentCenter {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinTable(name = "EMPLOYMENT_CENTER_VACANCY_LINK",
            joinColumns = @JoinColumn(name = "EMPLOYMENT_CENTER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "VACANCY_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Vacancy> vacancies;

    @JoinTable(name = "EMPLOYMENT_CENTER_CITIZEN_LINK",
            joinColumns = @JoinColumn(name = "EMPLOYMENT_CENTER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CITIZEN_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Citizen> citizens;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employmentCenter")
    private RegistrationCard registrationCard;

    public RegistrationCard getRegistrationCard() {
        return registrationCard;
    }

    public void setRegistrationCard(RegistrationCard registrationCard) {
        this.registrationCard = registrationCard;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"id"})
    public String getInstanceName() {
        return String.format("%s", id);
    }
}
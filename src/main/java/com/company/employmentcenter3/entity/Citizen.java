package com.company.employmentcenter3.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CITIZEN")
@Entity
public class Citizen {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "SURNAME", nullable = false)
    @NotNull
    private String surname;

    @Column(name = "PATRONYMIC", nullable = false)
    @NotNull
    private String patronymic;

    @Column(name = "PROFESSION", nullable = false)
    @NotNull
    private String profession;

    @Column(name = "SIGN_OF_DEVICE_FOR_WORK", nullable = false)
    @NotNull
    private Boolean signOfDeviceForWork = false;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "citizen")
    private RegistrationCard registrationCard;

    @JoinTable(name = "EMPLOYMENT_CENTER_CITIZEN_LINK",
            joinColumns = @JoinColumn(name = "CITIZEN_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYMENT_CENTER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<EmploymentCenter> employmentCenters;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public List<EmploymentCenter> getEmploymentCenters() {
        return employmentCenters;
    }

    public void setEmploymentCenters(List<EmploymentCenter> employmentCenters) {
        this.employmentCenters = employmentCenters;
    }

    public RegistrationCard getRegistrationCard() {
        return registrationCard;
    }

    public void setRegistrationCard(RegistrationCard registrationCard) {
        this.registrationCard = registrationCard;
    }

    public Boolean getSignOfDeviceForWork() {
        return signOfDeviceForWork;
    }

    public void setSignOfDeviceForWork(Boolean signOfDeviceForWork) {
        this.signOfDeviceForWork = signOfDeviceForWork;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
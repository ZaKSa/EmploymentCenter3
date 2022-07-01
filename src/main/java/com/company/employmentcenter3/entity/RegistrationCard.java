package com.company.employmentcenter3.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "REGISTRATION_CARD", indexes = {
        @Index(name = "IDX_REGISTRATIONCARD", columnList = "CITIZEN_ID"),
        @Index(name = "IDX_REGISTRATIONCARD", columnList = "EMPLOYMENT_CENTER_ID")
})
@Entity
public class RegistrationCard {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "EMPLOYMENT_CENTER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private EmploymentCenter employmentCenter;

    @Column(name = "DATE_OF_REGISTRATION", nullable = false)
    @NotNull
    private LocalDate dateOfRegistration;

    @PositiveOrZero
    @Column(name = "AMOUNT_OF_BENEFIT_PAID")
    private Integer amountOfBenefitPaid;

    @Column(name = "INDICATION_OF_BENEFIT_PAYMENT", nullable = false)
    @NotNull
    private Boolean indicationOfBenefitPayment = false;

    @Column(name = "DATE_OF_EMPLOYMENT")
    private LocalDate dateOfEmployment;

    @JoinColumn(name = "CITIZEN_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Citizen citizen;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public EmploymentCenter getEmploymentCenter() {
        return employmentCenter;
    }

    public void setEmploymentCenter(EmploymentCenter employmentCenter) {
        this.employmentCenter = employmentCenter;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public Boolean getIndicationOfBenefitPayment() {
        return indicationOfBenefitPayment;
    }

    public void setIndicationOfBenefitPayment(Boolean indicationOfBenefitPayment) {
        this.indicationOfBenefitPayment = indicationOfBenefitPayment;
    }

    public Integer getAmountOfBenefitPaid() {
        return amountOfBenefitPaid;
    }

    public void setAmountOfBenefitPaid(Integer amountOfBenefitPaid) {
        this.amountOfBenefitPaid = amountOfBenefitPaid;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
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
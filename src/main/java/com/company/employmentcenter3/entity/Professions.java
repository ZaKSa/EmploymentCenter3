package com.company.employmentcenter3.entity;

import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;

import java.util.UUID;

@JmixEntity
public class Professions {

    @JmixId
    private UUID professionsId;

    public UUID getProfessionsId() {
        return professionsId;
    }

    public void setProfessionsId(UUID id) {
        this.professionsId = id;
    }
}
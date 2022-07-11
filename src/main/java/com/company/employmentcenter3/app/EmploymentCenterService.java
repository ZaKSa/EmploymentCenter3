package com.company.employmentcenter3.app;

import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.EmploymentCenter;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmploymentCenterService {
    @Autowired
    private DataManager dataManager;

    List<Vacancy> allVacancy() {
        return dataManager.load(Vacancy.class).all().list();
    }

    List<Citizen> allCitizen() {
        return dataManager.load(Citizen.class).all().list();
    }

}
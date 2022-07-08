package com.company.employmentcenter3.app;

import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.SuitableProfessions;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VacancyService {

    @Autowired
    private DataManager dataManager;

    public List<Vacancy> findVacancies(Citizen citizen) {
        //Citizen citizen = dataManager.load(Citizen.class)
        //        .id(userId).one();
        if (citizen==null){
            return dataManager.load(Vacancy.class).all().list();
        }
        List<Vacancy> allVacancy = dataManager.load(Vacancy.class).all().list()
                .stream()
                .filter(vacancy ->
                        vacancy.getProfessions().contains(citizen.getProfession()))
                .collect(Collectors.toList());
        return allVacancy;
    }
}
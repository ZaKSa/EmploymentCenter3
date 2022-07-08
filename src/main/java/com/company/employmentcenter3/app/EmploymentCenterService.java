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




    /*public boolean haveBenefitPayment(Id<Citizen> userId) {
        Citizen citizen = dataManager.load(userId).one();

        //ставка×оклад<МРОТ
        Integer salary = dataManager.loadValue("select sum(te.timeSpent) from TimeEntry te where te.task.project.id = :projectId", Integer.class)
                .parameter("projectId", projectId)
                .one();
        Double bet = dataManager.loadValue("select sum(te.timeSpent) from TimeEntry te where te.task.project.id = :projectId", Integer.class)
                .parameter("projectId", projectId)
                .one();
        return ;
    }*/


    /*public List<EmploymentCenter> fetchVacancies() {
        List<Vacancy> projects = dataManager.load(Vacancy.class).all().fetchPlan("vacancy-fetch-plan").list();
        List<EmploymentCenter> projectStats = projects.stream().map(project -> {

            List<Vacancy> vacancyList = new ArrayList<>();
            for (Vacancy vacancy: projects) {
                Vacancy vacancy_ = dataManager.create(Vacancy.class);
                vacancy_.setId(vacancy.getId());
                vacancy_.setPost(vacancy.getPost());
                vacancy_.setSalary(vacancy.getSalary());
                vacancy_.setBet(vacancy.getBet());
                vacancy_.setDateOfVacancyRegistration(vacancy.getDateOfVacancyRegistration());
                vacancy_.setNameOfEmployer(vacancy.getNameOfEmployer());
                vacancy_.setProfessions(vacancy.getProfessions());
                vacancy_.setEmploymentCenters(vacancy.getEmploymentCenters());
            }

            EmploymentCenter stat = dataManager.create(EmploymentCenter.class);
            stat.setVacancies(vacancyList);
            return stat;
        }).collect(Collectors.toList());
        return projectStats;
    }*/

}
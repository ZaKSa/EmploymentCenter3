package com.company.employmentcenter3.app;

import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.RegistrationCard;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.ui.component.CheckBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CitizenService {

    @Autowired
    private DataManager dataManager;

    Integer minimumWage = 15279; //МРОТ в России



    //при выборе вакансии
    public void haveBenefitPayment(UUID vacancyId, UUID citizenId) {
        Vacancy vacancy = dataManager.load(Vacancy.class).id(vacancyId).one();
        Citizen citizen = dataManager.load(Citizen.class).id(citizenId).one();

        //находим карточку регистрации
        UUID regId = dataManager.loadValue("select reg.id from RegistrationCard reg where reg.citizen.id = :citizenId", UUID.class)
                .parameter("citizenId", citizenId)
                .one();
        RegistrationCard registrationCard = dataManager.load(RegistrationCard.class)
                .id(regId)
                .one();

        Integer salary = dataManager.loadValue("select v.salary from Vacancy v where v.id = :vacancyId", Integer.class)
                .parameter("vacancyId", vacancyId)
                .one();
        Double bet = dataManager.loadValue("select v.bet from Vacancy v where v.id = :vacancyId", Double.class)
                .parameter("vacancyId", vacancyId)
                .one();

        LocalDate date = LocalDate.now();
        registrationCard.setDateOfEmployment(date);

        citizen.setSignOfDeviceForWork(Boolean.TRUE);
        //signOfDeviceForWorkField.setValue(Boolean.TRUE);
        //ставка×оклад<МРОТ
        if (salary*bet < minimumWage){
            registrationCard.setIndicationOfBenefitPayment(Boolean.TRUE);
        }
        else {
            registrationCard.setIndicationOfBenefitPayment(Boolean.FALSE);
        }

        //удаляем вакансию
        //dataManager.remove(vacancy);
        //return ;
    }

}
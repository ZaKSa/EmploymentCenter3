package com.company.employmentcenter3.app;

import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.SuitableProfessions;
import com.company.employmentcenter3.entity.User;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.core.Sort;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import io.jmix.core.querycondition.Condition;
import java.util.stream.Collectors;

@Service
public class RegistrationCardService {

    Integer minimumWage = 15279; //МРОТ в России

    @Autowired
    private DataManager dataManager;

    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;

    private String getSubstitutedUserName() {
        User substitutedUser = (User) currentUserSubstitution.getSubstitutedUser();
        return substitutedUser == null ? "" : substitutedUser.getUsername();
    }


    public List<SuitableProfessions> loadVacancy(Condition loadContext, Sort sort, int firstResult, int maxResults) {
        return new ArrayList<>();
    }

    /*
    List<String> getProductNames(Id<Order> orderId) {
    Order order = dataManager.load(orderId).one();
    return order.getLines().stream()
            .map(orderLine -> orderLine.getProduct().getName())
            .collect(Collectors.toList());
     */

    /*public Citizen getActualCitizen(UUID userId) {
        return dataManager.loadValue("select * from Citizen ce where ce.citizen.id = :userId", Citizen.class)
                .parameter("userId", userId)
                .one();
    }*/
}
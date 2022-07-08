package com.company.employmentcenter3.screen.suitableprofessions;

import com.company.employmentcenter3.app.RegistrationCardService;
import com.company.employmentcenter3.entity.RegistrationCard;

import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.SuitableProfessions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@UiController("SuitableProfessions.browse")
@UiDescriptor("suitable-professions-browse.xml")
@LookupComponent("suitableProfessionsesTable")
public class SuitableProfessionsBrowse extends StandardLookup<SuitableProfessions> {

    @Autowired
    private RegistrationCardService registrationCardService;



    @Install(to = "suitableProfessionsDL", target = Target.DATA_LOADER)
    private List<SuitableProfessions> suitableProfessionsDLLoadDelegate(LoadContext<SuitableProfessions> loadContext) {
        LoadContext.Query query = loadContext.getQuery();
        return registrationCardService.loadVacancy(
                query.getCondition(),
                query.getSort(),
                query.getFirstResult(),
                query.getMaxResults()
        );
        //return registrationCardService.findVacancies(loadContext.get); /////////////
    }

}
package com.company.employmentcenter3.screen.vacancy;

import com.company.employmentcenter3.app.VacancyService;
import com.company.employmentcenter3.entity.Citizen;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

@UiController("Vacancy.browse")
@UiDescriptor("vacancy-browse.xml")
@LookupComponent("vacanciesTable")
public class VacancyBrowse extends StandardLookup<Vacancy> {

    @Autowired
    private VacancyService vacancyService;

    private Citizen selectedCitizen = null;

    @Named("vacanciesDl")
    private CollectionLoader<Vacancy> vacanciesDl;


    @Install(to = "vacanciesDl", target = Target.DATA_LOADER)
    private List<Vacancy> vacancyDlLoadDelegate(LoadContext<Vacancy> loadContext) {
        return vacancyService.findVacancies(selectedCitizen);
    }

    @Subscribe("selectedCitizenField")
    public void onSelectedCitizenFieldValueChange(HasValue.ValueChangeEvent<Citizen> event) {
        selectedCitizen = event.getValue();
        vacanciesDl.load();
    }

}
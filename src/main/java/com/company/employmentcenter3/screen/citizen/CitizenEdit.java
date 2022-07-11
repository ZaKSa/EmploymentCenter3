package com.company.employmentcenter3.screen.citizen;

import com.company.employmentcenter3.app.CitizenService;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.Id;
import io.jmix.core.LoadContext;
import io.jmix.ui.component.CheckBox;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@UiController("Citizen.edit")
@UiDescriptor("citizen-edit.xml")
@EditedEntityContainer("citizenDc")
public class CitizenEdit extends StandardEditor<Citizen> {
    private Vacancy selectedVacancy;
    private Citizen selectedCitizen;
    @Autowired
    CitizenService citizenService;

    @Autowired
    private CheckBox signOfDeviceForWorkField;



    @Named("vacanciesDl")
    private CollectionLoader<Vacancy> vacanciesDl;

    @Subscribe("vacancyField")
    public void onSelectedVacancyFieldValueChange(HasValue.ValueChangeEvent<Vacancy> event) {
        signOfDeviceForWorkField.setValue(Boolean.TRUE);

        selectedVacancy = event.getValue();
        selectedCitizen = getEditedEntity();
        citizenService.haveBenefitPayment(selectedVacancy.getId(), selectedCitizen.getId());
    vacanciesDl.load();
    }

    @Autowired
    private TextField nameField;
    @Autowired
    private TextField surnameField;
    @Autowired
    private TextField patronymicField;
    @Autowired
    private TextField professionField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        getScreenData().loadAll();
    }






}
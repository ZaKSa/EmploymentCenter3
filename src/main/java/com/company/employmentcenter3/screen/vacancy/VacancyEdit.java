package com.company.employmentcenter3.screen.vacancy;

import io.jmix.ui.component.DateField;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@UiController("Vacancy.edit")
@UiDescriptor("vacancy-edit.xml")
@EditedEntityContainer("vacancyDc")
public class VacancyEdit extends StandardEditor<Vacancy> {
    @Autowired
    private DateField dateOfVacancyRegistrationField;

       @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        dateOfVacancyRegistrationField.setValue(LocalDate.now());
    }
}
package com.company.employmentcenter3.screen.vacancy;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Vacancy;

@UiController("Vacancy.edit")
@UiDescriptor("vacancy-edit.xml")
@EditedEntityContainer("vacancyDc")
public class VacancyEdit extends StandardEditor<Vacancy> {
    @Subscribe
    public void onInitEntity(InitEntityEvent<Vacancy> event) {
        
    }
}
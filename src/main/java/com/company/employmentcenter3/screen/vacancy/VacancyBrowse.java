package com.company.employmentcenter3.screen.vacancy;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Vacancy;

@UiController("Vacancy.browse")
@UiDescriptor("vacancy-browse.xml")
@LookupComponent("vacanciesTable")
public class VacancyBrowse extends StandardLookup<Vacancy> {
}
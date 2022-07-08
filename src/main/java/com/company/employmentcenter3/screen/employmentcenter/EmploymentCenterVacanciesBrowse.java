package com.company.employmentcenter3.screen.employmentcenter;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.EmploymentCenter;

@UiController("EmploymentCenterVacancies.browse")
@UiDescriptor("employment-center-vacancies-browse.xml")
@LookupComponent("employmentCentersTable")
public class EmploymentCenterVacanciesBrowse extends StandardLookup<EmploymentCenter> {
}
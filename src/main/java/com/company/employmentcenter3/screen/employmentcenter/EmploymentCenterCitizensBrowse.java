package com.company.employmentcenter3.screen.employmentcenter;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.EmploymentCenter;

@UiController("EmploymentCenterCitizens.browse")
@UiDescriptor("employment-center-citizens-browse.xml")
@LookupComponent("employmentCentersTable")
public class EmploymentCenterCitizensBrowse extends StandardLookup<EmploymentCenter> {
}
package com.company.employmentcenter3.screen.employmentcenter;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.EmploymentCenter;

@UiController("EmploymentCenter.browse")
@UiDescriptor("employment-center-browse.xml")
@LookupComponent("employmentCentersTable")
public class EmploymentCenterBrowse extends StandardLookup<EmploymentCenter> {
}
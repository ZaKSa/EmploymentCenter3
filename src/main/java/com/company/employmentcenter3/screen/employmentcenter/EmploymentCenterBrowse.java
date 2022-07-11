package com.company.employmentcenter3.screen.employmentcenter;

import io.jmix.ui.ScreenTools;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.EmploymentCenter;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("EmploymentCenter.browse")
@UiDescriptor("employment-center-browse.xml")
@LookupComponent("employmentCentersTable")
public class EmploymentCenterBrowse extends StandardLookup<EmploymentCenter> {

}
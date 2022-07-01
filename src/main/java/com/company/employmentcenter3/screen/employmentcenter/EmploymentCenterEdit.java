package com.company.employmentcenter3.screen.employmentcenter;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.EmploymentCenter;

@UiController("EmploymentCenter.edit")
@UiDescriptor("employment-center-edit.xml")
@EditedEntityContainer("employmentCenterDc")
public class EmploymentCenterEdit extends StandardEditor<EmploymentCenter> {
}
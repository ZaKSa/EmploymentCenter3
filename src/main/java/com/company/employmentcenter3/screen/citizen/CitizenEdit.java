package com.company.employmentcenter3.screen.citizen;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Citizen;

@UiController("Citizen.edit")
@UiDescriptor("citizen-edit.xml")
@EditedEntityContainer("citizenDc")
public class CitizenEdit extends StandardEditor<Citizen> {
}
package com.company.employmentcenter3.screen.citizen;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.Citizen;

@UiController("Citizen.browse")
@UiDescriptor("citizen-browse.xml")
@LookupComponent("citizensTable")
public class CitizenBrowse extends StandardLookup<Citizen> {
}
package com.company.employmentcenter3.screen.registrationcard;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.RegistrationCard;

@UiController("RegistrationCard.browse")
@UiDescriptor("registration-card-browse.xml")
@LookupComponent("registrationCardsTable")
public class RegistrationCardBrowse extends StandardLookup<RegistrationCard> {
}
package com.company.employmentcenter3.screen.registrationcard;

import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.RegistrationCard;

@UiController("RegistrationCard.edit")
@UiDescriptor("registration-card-edit.xml")
@EditedEntityContainer("registrationCardDc")
public class RegistrationCardEdit extends StandardEditor<RegistrationCard> {
}
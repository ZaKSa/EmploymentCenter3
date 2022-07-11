package com.company.employmentcenter3.screen.registrationcard;

import com.company.employmentcenter3.app.RegistrationCardService;
import com.company.employmentcenter3.app.VacancyService;
import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.Vacancy;
import com.company.employmentcenter3.screen.suitableprofessions.SuitableProfessionsBrowse;
import com.company.employmentcenter3.screen.vacancy.VacancyScreen;
import io.jmix.core.DataManager;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.Screens;
import io.jmix.ui.action.Action;
import io.jmix.ui.action.entitypicker.EntityLookupAction;
import io.jmix.ui.component.*;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.RegistrationCard;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@UiController("RegistrationCard.edit")
@UiDescriptor("registration-card-edit.xml")
@EditedEntityContainer("registrationCardDc")
public class RegistrationCardEdit extends StandardEditor<RegistrationCard> {
    @Autowired
    private Form form;
    @Autowired
    private VacancyService vacancyService;

    private Integer amountOfBenefitPaid = 12790;
    @Autowired
    private EntityPicker<Citizen> citizenField;

    @Autowired
    private DataManager dataManager;

    @Named("citizenField.entityLookup")
    private EntityLookupAction<Citizen> citizenFieldEntityLookup;

    @Autowired
    private Screens screens;
    @Autowired
    private ScreenBuilders screenBuilders;

    @Autowired
    private DateField dateOfRegistrationField;
    @Autowired
    private TextField amountOfBenefitPaidField;

    @Inject
    protected EditorScreenFacet editorScreen;

    @Autowired
    protected InstanceContainer<RegistrationCard> registrationCardDc;

    private void editSelectedEntity(Citizen entity) {
        screenBuilders.editor(Citizen.class, this)
                .editEntity(entity)
                .build()
                .show();
    }
    /*@Subscribe
    public void onInitEntity(InitEntityEvent<Vacancy> event) {
        dateOfVacancyRegistrationField.setValue(LocalDate.now());
    }*/

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        dateOfRegistrationField.setValue(LocalDate.now());
        amountOfBenefitPaidField.setValue(amountOfBenefitPaid);
    }

    @Subscribe("editBtn")
    protected void onEditButtonClick(Button.ClickEvent event) {
        //editSelectedEntity(citizenField.getValue());
        //RegistrationCard registrationCard = registrationCardDc.getItem();
        //Citizen citizen = citizenField.getValue();

//        editorScreen.show();
        //nameField.setValue(registrationCard.getCitizen().getName());
        //surnameField.setValue(registrationCard.getCitizen().getSurname());

    }

    /*@Subscribe("customerEntityPicker.points")
    public void onCustomerEntityPickerPoints(Action.ActionPerformedEvent event) {
        Customer customer = customerEntityPicker.getValue();
        if (customer != null) {
            notifications.create()
                    .withCaption(customer.getFirstName() +
                            " has " + customer.getRewardPoints() +
                            " reward points")
                    .show();
        } else {
            notifications.create()
                    .withCaption("Choose a customer")
                    .show();
        }
    }*/
}
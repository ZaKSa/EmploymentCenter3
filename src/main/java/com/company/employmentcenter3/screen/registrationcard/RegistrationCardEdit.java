package com.company.employmentcenter3.screen.registrationcard;

import com.company.employmentcenter3.app.CitizenService;
import com.company.employmentcenter3.app.VacancyService;
import com.company.employmentcenter3.entity.Citizen;
import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.core.DataManager;
import io.jmix.ui.Dialogs;
import io.jmix.ui.Notifications;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.Screens;
import io.jmix.ui.action.entitypicker.EntityLookupAction;
import io.jmix.ui.component.*;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.RegistrationCard;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.UUID;

@UiController("RegistrationCard.edit")
@UiDescriptor("registration-card-edit.xml")
@EditedEntityContainer("registrationCardDc")
public class RegistrationCardEdit extends StandardEditor<RegistrationCard> {
    private Integer amountOfBenefitPaid = 12790;
    @Autowired
    private EntityPicker<Citizen> citizenField;

    @Autowired
    private DataManager dataManager;

    @Autowired
    private ScreenBuilders screenBuilders;

    @Autowired
    private DateField dateOfRegistrationField;
    @Autowired
    private TextField amountOfBenefitPaidField;
    @Autowired
    private DateField dateOfEmploymentField;
    @Named("vacanciesDl")
    private CollectionLoader<Vacancy> vacanciesDl;

    private Vacancy selectedVacancy;
    private Citizen selectedCitizen;

    @Autowired
    CitizenService citizenService;

    @Autowired
    private Notifications notifications;

    @Autowired
    private Dialogs dialogs;

    @Autowired
    private MessageBundle messageBundle;
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

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        dateOfRegistrationField.setValue(LocalDate.now());
        amountOfBenefitPaidField.setValue(amountOfBenefitPaid);
    }

    @Subscribe("editBtn")
    protected void onEditButtonClick(Button.ClickEvent event) {
        Citizen citizen = citizenField.getValue();
        UUID citizenId = citizen.getId();
    }


    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
            selectedCitizen = citizenField.getValue();
            UUID regId = dataManager.loadValue("select reg.citizen.id from RegistrationCard reg where reg.citizen.id = :citizenId", UUID.class)
                .parameter("citizenId", selectedCitizen.getId())
                .one();

            if (regId == null) {
                selectedVacancy = selectedCitizen.getVacancy();
                citizenService.haveBenefitPayment(selectedVacancy.getId(), selectedCitizen.getId());
                vacanciesDl.load();
                Citizen citizen = citizenField.getValue();
                if (selectedCitizen.getVacancy() != null) {
                    dateOfEmploymentField.setValue(LocalDate.now());
                }
                this.closeWithCommit();
            }
            else {
                notifications.create().withCaption(messageBundle.getMessage("registrationCardEdit.ExceptionMessage"))
                         .show();

            }
    }
}
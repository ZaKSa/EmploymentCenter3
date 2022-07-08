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
import io.jmix.ui.action.entitypicker.EntityLookupAction;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.EntityPicker;
import io.jmix.ui.component.Form;
import io.jmix.ui.screen.*;
import com.company.employmentcenter3.entity.RegistrationCard;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;

@UiController("RegistrationCard.edit")
@UiDescriptor("registration-card-edit.xml")
@EditedEntityContainer("registrationCardDc")
public class RegistrationCardEdit extends StandardEditor<RegistrationCard> {
    @Autowired
    private Form form;
    @Autowired
    private VacancyService vacancyService;


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

    /*private void showFancyScreen(String message) {
        FancyMessageScreen fancyScreen = screens.create(FancyMessageScreen.class);
        fancyScreen.setFancyMessage(message);
        screens.show(fancyScreen);
    }

    private void openOtherScreen() {
        screenBuilders.screen(this)
                .withScreenClass(RegistrationCardEdit.class)
                .withAfterCloseListener(e -> {
                    if (e.closedWith(StandardOutcome.COMMIT)) {
                        getScreenData().loadAll();
                    }
                })
                .build()
                .show();
    }*/
/*
screenBuilders.editor(Talk.class, this)
                .editEntity((Talk) event.getEntity())
                .withOpenMode(OpenMode.DIALOG)
                .withScreenClass(TalkEdit.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                        getScreenData().loadAll();
                    }
                }).show();
 */
    @Subscribe("showVacanciesBtn")
    protected void onShowButtonClick(Button.ClickEvent event) {

        Citizen citizen = citizenField.getValue();
        //List<Vacancy> showVacancies = vacancyService.findVacancies(citizen.getId());

        //SuitableProfessionsBrowse fancyScreen = screens.create(SuitableProfessionsBrowse.class);
        //fancyScreen.setVacancy(showVacancies);
        //screens.show(fancyScreen);

        /*screenBuilders.screen(this)
                .withScreenClass(RegistrationCardEdit.class)
                .withAfterCloseListener(e -> {
                    if (e.closedWith(StandardOutcome.COMMIT)) {
                        getScreenData().loadAll();
                    }
                })
                .build()
                .show();
*/
    }

    /*@Subscribe("someAction")
    protected void onSomeActionActionPerformed(Action.ActionPerformedEvent event) {
        notifications.create()
                .withCaption("Action performed")
                .show();
    }*/

}
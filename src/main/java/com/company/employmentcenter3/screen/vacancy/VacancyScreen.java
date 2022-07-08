package com.company.employmentcenter3.screen.vacancy;

import com.company.employmentcenter3.entity.Vacancy;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@UiController("Vacancy.Screen")
@UiDescriptor("vacancy-screen.xml")
public class VacancyScreen extends Screen {

    @Autowired
    private List<Vacancy> showVacancy;

    public void setVacancies(List<Vacancy> showVacancy1) {
            showVacancy.addAll(showVacancy1);
    }

    @Subscribe("closeBtn")
    protected void onCloseBtnClick(Button.ClickEvent event) {
        closeWithDefaultAction();
    }
}

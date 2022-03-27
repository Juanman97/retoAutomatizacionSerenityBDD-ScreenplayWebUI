package co.com.sofka.task.createaccount;

import co.com.sofka.model.createaccount.FullFormModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.*;
import static co.com.sofka.util.RegisterUserTitle.MR_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillFullRegisterForm implements Task {
    private FullFormModel model;

    public FillFullRegisterForm usingModel(FullFormModel fullFormModel) {
        this.model = fullFormModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(FIRSTNAME, isVisible()).forNoMoreThan(10).seconds(),

                Scroll.to(FIRSTNAME),
                Enter.theValue(model.getFirstName()).into(FIRSTNAME),

                Check.whether(MR_TITLE.getValue().equals(model.getTitle().getValue()))
                        .andIfSo(
                                Scroll.to(TITLE_MR),
                                Click.on(TITLE_MR)
                        )
                        .otherwise(
                                Scroll.to(TITLE_MRS),
                                Click.on(TITLE_MRS)
                        ),

                Scroll.to(LASTNAME),
                Enter.theValue(model.getLastName()).into(LASTNAME),

                Scroll.to(PASSWORD),
                Enter.theValue(model.getPassword()).into(PASSWORD),

                Scroll.to(BIRTH_DATE_DAY),
                SelectFromOptions.byValue(model.getBirthDateDay()).from(BIRTH_DATE_DAY),

                Scroll.to(BIRTH_DATE_MONTH),
                SelectFromOptions.byValue(model.getBirthDateMonth()).from(BIRTH_DATE_MONTH),

                Scroll.to(BIRTH_DATE_YEAR),
                SelectFromOptions.byValue(model.getBirthDateYear()).from(BIRTH_DATE_YEAR),

                Scroll.to(COMPANY),
                Enter.theValue(model.getCompany()).into(COMPANY),

                Scroll.to(ADDRESS),
                Enter.theValue(model.getAddress()).into(ADDRESS),

                Scroll.to(ADDRESS_COMPLEMENT),
                Enter.theValue(model.getAddressComplement()).into(ADDRESS_COMPLEMENT),

                Scroll.to(CITY),
                Enter.theValue(model.getCity()).into(CITY),

                Scroll.to(STATE),
                SelectFromOptions.byVisibleText(model.getState()).from(STATE),

                Scroll.to(POSTAL_CODE),
                Enter.theValue(model.getZip()).into(POSTAL_CODE),

                Scroll.to(COUNTRY),
                SelectFromOptions.byVisibleText(model.getCountry()).from(COUNTRY),

                Scroll.to(ADDITIONAL_INFO),
                Enter.theValue(model.getAdditionalInfo()).into(ADDITIONAL_INFO),

                Scroll.to(HOME_PHONE),
                Enter.theValue(model.getHomePhone()).into(HOME_PHONE),

                Scroll.to(MOBILE_PHONE),
                Enter.theValue(model.getMobilePhone()).into(MOBILE_PHONE),

                Scroll.to(ADDRESS_ALIAS),
                Enter.theValue(model.getAddresAlias()).into(ADDRESS_ALIAS),

                Scroll.to(SUBMIT_BUTTON),
                Click.on(SUBMIT_BUTTON)
                );
    }

    public static FillFullRegisterForm fillFullRegisterForm() {
        return new FillFullRegisterForm();
    }
}

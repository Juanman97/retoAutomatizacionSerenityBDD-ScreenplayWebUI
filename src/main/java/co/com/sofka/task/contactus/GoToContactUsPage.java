package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.contactus.ContactUsTargets.*;

public class GoToContactUsPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CONTACT_US),
                Click.on(CONTACT_US)
        );
    }
    public static GoToContactUsPage goToContactUsPage() {
        return new GoToContactUsPage();
    }
}

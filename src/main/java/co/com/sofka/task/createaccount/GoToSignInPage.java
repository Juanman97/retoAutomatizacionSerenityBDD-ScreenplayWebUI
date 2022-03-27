package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.*;

public class GoToSignInPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN),
                Click.on(SIGN_IN)
        );
    }
    public static GoToSignInPage goToSignInPage() {
        return new GoToSignInPage();
    }
}

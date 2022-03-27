package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.CREATE_ACCOUNT_BUTTON;
import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.EMAIL;

public class EnterEmail implements Task {
    private String email;

    public EnterEmail UsingEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),

                //Scroll.to(CREATE_ACCOUNT_BUTTON),
                Click.on(CREATE_ACCOUNT_BUTTON)
        );
    }

    public static EnterEmail enterEmail() {
        return new EnterEmail();
    }
}

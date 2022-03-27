package co.com.sofka.task.signin;

import co.com.sofka.model.signin.SignInCredentialsModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.signin.SignInTargets.*;

public class LogIn implements Task {
    private SignInCredentialsModel signInModel;

    public LogIn usinModel(SignInCredentialsModel signInModel) {
        this.signInModel = signInModel;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_FIELD),
                Enter.theValue(signInModel.getEmail()).into(EMAIL_FIELD),

                Scroll.to(PASSWORD_FIELD),
                Enter.theValue(signInModel.getPassword()).into(PASSWORD_FIELD),

                Scroll.to(SUBMIT_LOGIN_BUTTON),
                Click.on(SUBMIT_LOGIN_BUTTON)
        );
    }

    public static LogIn logIn() {
        return new LogIn();
    }
}

package co.com.sofka.question.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.signin.SignInTargets.AUTH_FAILED_MESSAGE;

public class WrongPasswordError implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return AUTH_FAILED_MESSAGE.resolveFor(actor).isDisplayed();
    }

    public static WrongPasswordError wrongPasswordError() {
        return new WrongPasswordError();
    }
}

package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.INVALID_PASSWORD_ERROR;

public class InvalidPasswordError implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return INVALID_PASSWORD_ERROR.resolveFor(actor).isDisplayed();
    }

    public static InvalidPasswordError invalidPasswordError() {
        return new InvalidPasswordError();
    }
}

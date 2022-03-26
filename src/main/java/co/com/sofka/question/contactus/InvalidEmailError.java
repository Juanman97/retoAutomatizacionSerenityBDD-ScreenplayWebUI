package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsTargets.INVALID_EMAIL_ERROR;

public class InvalidEmailError implements Question {
    @Override
    public String answeredBy(Actor actor) {
        return INVALID_EMAIL_ERROR.resolveFor(actor).getText();
    }

    public static InvalidEmailError invalidEmailError() {
        return new InvalidEmailError();
    }
}

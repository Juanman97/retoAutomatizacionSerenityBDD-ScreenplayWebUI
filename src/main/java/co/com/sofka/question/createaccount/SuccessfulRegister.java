package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.createaccount.CreateAccountTargets.WELCOME_TO_YOUR_ACCOUNT_MESSAGE;

public class SuccessfulRegister implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return WELCOME_TO_YOUR_ACCOUNT_MESSAGE.resolveFor(actor).isDisplayed();
    }

    public static SuccessfulRegister successfulRegister() {
        return new SuccessfulRegister();
    }
}

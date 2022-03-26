package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsTargets.SUCCESSFULL_RESULT;

public class MessageSuccessfullySent implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        return SUCCESSFULL_RESULT.resolveFor(actor).isDisplayed();
    }

    public static MessageSuccessfullySent messageSuccessfullySent() {
        return new MessageSuccessfullySent();
    }
}

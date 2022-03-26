package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import java.nio.file.Path;

import static co.com.sofka.userinterface.contactus.ContactUsTargets.*;

public class FillFullForm implements Task {
    private String subjectHeading;
    private String email;
    private String order;
    private String message;
    private Path filePath;

    public FillFullForm usingSubjectHeading(String subjectHeading) {
        this.subjectHeading = subjectHeading;
        return this;
    }

    public FillFullForm usingEmail(String email) {
        this.email = email;
        return this;
    }

    public FillFullForm usingOrder(String order) {
        this.order = order;
        return this;
    }

    public FillFullForm usingMessage(String message) {
        this.message = message;
        return this;
    }

    public FillFullForm andUsingFilePath(Path filePath) {
        this.filePath = filePath;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SUBJECT_HEADING_SELECTOR),
                SelectFromOptions.byVisibleText(subjectHeading).from(SUBJECT_HEADING_SELECTOR),

                Scroll.to(EMAIL),
                Enter.theValue(email).into(EMAIL),

                Scroll.to(ORDER),
                Enter.theValue(order).into(ORDER),

                Scroll.to(MESSAGE),
                Enter.theValue(message).into(MESSAGE),

                Scroll.to(FILE_UPLOAD),
                Upload.theFile(filePath).to(FILE_UPLOAD),

                Scroll.to(SEND_BUTTON),
                Click.on(SEND_BUTTON)
        );
    }

    public static FillFullForm fillFullForm() {
        return new FillFullForm();
    }
}

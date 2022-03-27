package co.com.sofka.task.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.signin.SignInTargets.LOG_OUT;

public class LogOut implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(LOG_OUT),
                Click.on(LOG_OUT)
        );
    }

    public static LogOut logOut() {
        return new LogOut();
    }
}

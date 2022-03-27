package co.com.sofka.userinterface.signin;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class SignInTargets extends PageObject {
    //Cerrar sesion
    public static final Target LOG_OUT = Target
            .the("Log out button")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a"));

    //Iniciar sesion
    public static final Target EMAIL_FIELD = Target
            .the("Email input field")
            .located(By.id("email"));

    public static final Target PASSWORD_FIELD = Target
            .the("Password input field")
            .located(By.id("passwd"));

    public static final Target SUBMIT_LOGIN_BUTTON = Target
            .the("Submit login button")
            .located(By.id("SubmitLogin"));

    //assertions
    public static final Target WELCOME_TO_YOUR_ACCOUNT_MESSAGE = Target
            .the("Welcome to your account message")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

    public static final Target AUTH_FAILED_MESSAGE = Target
            .the("Authentication failed message")
            .located(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
}

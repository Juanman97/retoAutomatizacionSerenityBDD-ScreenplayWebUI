package co.com.sofka.userinterface.createaccount;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CreateAccountTargets extends PageObject {
    //navegar a módulo sign in
    public static final Target SIGN_IN = Target
            .the("Sign in button")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

    //llenar datos
    public static final Target EMAIL = Target
            .the("email")
            .located(By.id("email_create"));

    public static final Target CREATE_ACCOUNT_BUTTON = Target
            .the("Create an account button")
            .located(By.id("SubmitCreate"));

    public static final Target TITLE_MR = Target
            .the("Title Mr.")
            .located(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label"));

    public static final Target TITLE_MRS = Target
            .the("Title Mrs.")
            .located(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[2]/label"));

    public static final Target FIRSTNAME = Target
            .the("First name")
            .located(By.id("customer_firstname"));

    public static final Target LASTNAME = Target
            .the("Last name")
            .located(By.id("customer_lastname"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(By.id("passwd"));

    public static final Target BIRTH_DATE_DAY = Target
            .the("Birth date day")
            .located(By.id("days"));

    public static final Target BIRTH_DATE_MONTH = Target
            .the("Birth date month")
            .located(By.id("months"));

    public static final Target BIRTH_DATE_YEAR = Target
            .the("Birth date year")
            .located(By.id("years"));

    public static final Target COMPANY = Target
            .the("Company")
            .located(By.id("company"));

    public static final Target ADDRESS = Target
            .the("Address")
            .located(By.id("address1"));

    public static final Target ADDRESS_COMPLEMENT = Target
            .the("Address complement")
            .located(By.id("address2"));

    public static final Target CITY = Target
            .the("City")
            .located(By.id("city"));

    public static final Target STATE = Target
            .the("State")
            .located(By.id("id_state"));

    public static final Target POSTAL_CODE = Target
            .the("Zip/Postal code")
            .located(By.id("postcode"));

    public static final Target COUNTRY = Target
            .the("Country")
            .located(By.id("id_country"));

    public static final Target ADDITIONAL_INFO = Target
            .the("Additional information")
            .located(By.id("other"));

    public static final Target HOME_PHONE = Target
            .the("Home phone")
            .located(By.id("phone"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile phone")
            .located(By.id("phone_mobile"));

    public static final Target ADDRESS_ALIAS = Target
            .the("Address alias")
            .located(By.id("alias"));

    public static final Target SUBMIT_BUTTON = Target
            .the("Submit account button")
            .located(By.id("submitAccount"));

    //assertions
    public static final Target WELCOME_TO_YOUR_ACCOUNT_MESSAGE = Target
            .the("Welcome to your account message")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

    public static final Target INVALID_PASSWORD_ERROR = Target
            .the("Invalid password error message")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
}

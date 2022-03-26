package co.com.sofka.userinterface.contactus;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ContactUsTargets extends PageObject {

    //navegar a módulo Contact Us
    public static final Target CONTACT_US = Target
            .the("Contact Us button")
            .located(By.xpath("//*[@id=\"contact-link\"]/a"));

    //llenar formulario
    public static final Target SUBJECT_HEADING_SELECTOR = Target
            .the("Subject header selector")
            .located(By.id("id_contact"));

    public static final Target EMAIL = Target
            .the("Email")
            .located(By.id("email"));

    public static final Target ORDER = Target
            .the("Order reference")
            .located(By.id("id_order"));

    public static final Target FILE_UPLOAD = Target
            .the("File upload")
            .located(By.id("fileUpload"));

    public static final Target MESSAGE = Target
            .the("Message")
            .located(By.id("message"));

    public static final Target SEND_BUTTON = Target
            .the("Send button")
            .located(By.id("submitMessage"));

    //assertions
    public static final Target SUCCESSFULL_RESULT = Target
            .the("Message successfully sent")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));

    public static final Target INVALID_EMAIL_ERROR = Target
            .the("Invalid email error message")
            .located(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));

}

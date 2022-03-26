package co.com.sofka.stepdefinition.contactus;

import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

import static co.com.sofka.question.contactus.InvalidEmailError.invalidEmailError;
import static co.com.sofka.question.contactus.MessageSuccessfullySent.messageSuccessfullySent;
import static co.com.sofka.task.contactus.FillFullForm.fillFullForm;
import static co.com.sofka.task.contactus.GoToContactUsPage.goToContactUsPage;
import static co.com.sofka.task.contactus.OpenLandingPage.openLandingPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsStepDefinition extends Setup {
    private static final String ACTOR_NAME = "Cliente";

    @Given("El usuario se encuentra en la pagina principal de la tienda")
    public void elUsuarioSeEncuentraEnLaPaginaPrincipalDeLaTienda() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Given("el usuario navega a la pagina de contact us")
    public void elUsuarioNavegaALaPaginaDeContactUs() {
        theActorInTheSpotlight().attemptsTo(
            goToContactUsPage()
        );
    }

    @When("el usuario llena el formulario completo y envia")
    public void elUsuarioLlenaElFormularioCompletoYEnvia() {
        theActorInTheSpotlight().attemptsTo(
                fillFullForm()
                        .usingSubjectHeading("Customer service")
                        .usingEmail("emailValido@gmail.com")
                        .usingOrder("123123")
                        .usingMessage("Este es un mensaje de prueba")
                        .andUsingFilePath(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\files\\prueba.txt"))
        );
    }

    @Then("el sistema mostrara un mensaje de envio satisfactorio")
    public void elSistemaMostraraUnMensajeDeEnvioSatisfactorio() {
        theActorInTheSpotlight().should(
                seeThat(messageSuccessfullySent(), equalTo(true))
        );
    }

    @When("el usuario llena el formulario usando el email {string}")
    public void elUsuarioLlenaElFormularioUsandoElEmail(String emailInvalido) {
        theActorInTheSpotlight().attemptsTo(
                fillFullForm()
                        .usingSubjectHeading("Customer service")
                        .usingEmail(emailInvalido)
                        .usingOrder("123123")
                        .usingMessage("Este es un mensaje de prueba")
                        .andUsingFilePath(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\files\\prueba.txt"))
        );
    }

    @Then("el sistema mostrara un mensaje de error")
    public void elSistemaMostraraUnMensajeDeError() {
        theActorInTheSpotlight().should(
                seeThat(invalidEmailError(), equalTo("Invalid email address."))
        );
    }
}

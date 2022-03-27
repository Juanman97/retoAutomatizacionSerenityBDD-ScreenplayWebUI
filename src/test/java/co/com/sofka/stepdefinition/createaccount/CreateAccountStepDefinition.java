package co.com.sofka.stepdefinition.createaccount;

import co.com.sofka.model.createaccount.FullFormModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.question.createaccount.InvalidPasswordError.invalidPasswordError;
import static co.com.sofka.question.createaccount.SuccessfulRegister.successfulRegister;
import static co.com.sofka.task.contactus.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.createaccount.EnterEmail.enterEmail;
import static co.com.sofka.task.createaccount.FillFullRegisterForm.fillFullRegisterForm;
import static co.com.sofka.task.createaccount.GoToSignInPage.goToSignInPage;
import static co.com.sofka.util.RandomEmailGenerator.randomEmail;
import static co.com.sofka.util.RegisterUserTitle.MR_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateAccountStepDefinition extends Setup {
    private static final String ACTOR_NAME = "Cliente";
    private static String RANDOM_EMAIL;
    private FullFormModel model;

    @Given("El usuario se encuentra en el home de la tienda")
    public void elUsuarioSeEncuentraEnElHomeDeLaTienda() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Given("el usuario navega a la pagina de login")
    public void elUsuarioNavegaALaPaginaDeLogin() {
        theActorInTheSpotlight().attemptsTo(
                goToSignInPage()
        );
    }

    @Given("el usuario ingresa un email aleatorio valido y confirma")
    public void elUsuarioIngresaUnEmailAleatorioValidoYConfirma() {
        RANDOM_EMAIL = randomEmail();
        theActorInTheSpotlight().attemptsTo(
                enterEmail().UsingEmail(RANDOM_EMAIL)
        );
    }

    @When("el usuario llena todos los campos y confirma")
    public void elUsuarioLlenaTodosLosCamposYConfirma() {
        model = setModelData();
        theActorInTheSpotlight().attemptsTo(
                fillFullRegisterForm().usingModel(model)
        );
    }

    @Then("el sistema mostrara un mensaje de bienvenida a la cuenta")
    public void elSistemaMostraraUnMensajeDeBienvenidaALaCuenta() {
        theActorInTheSpotlight().should(
                seeThat(successfulRegister(), equalTo(true))
        );
    }

    @When("el usuario llena todos los campos usando como contrasenia {string} y confirma")
    public void elUsuarioLlenaTodosLosCamposUsandoComoContraseniaYConfirma(String password) {
        model = setModelData();
        model.setPassword(password);
        theActorInTheSpotlight().attemptsTo(
                fillFullRegisterForm().usingModel(model)
        );
    }

    @Then("el sistema mostrara un mensaje de error de contrasenia invalida")
    public void elSistemaMostraraUnMensajeDeErrorDeContraseniaInvalida() {
        theActorInTheSpotlight().should(
                seeThat(invalidPasswordError(), equalTo(true))
        );
    }

    public static FullFormModel setModelData() {
        FullFormModel model = new FullFormModel();
        model.setTitle(MR_TITLE);
        model.setFirstName("Juan");
        model.setLastName("Reina");
        model.setPassword("123456");
        model.setBirthDateDay("30");
        model.setBirthDateMonth("9");
        model.setBirthDateYear("1997");
        model.setCompany("SofkaU");
        model.setAddress("calle 1 #20-22");
        model.setAddressComplement("Apartamento 202");
        model.setCity("Neiva");
        model.setState("California");
        model.setZip("41001");
        model.setCountry("United States");
        model.setAdditionalInfo("Esta es la info adicional");
        model.setHomePhone("123456789");
        model.setMobilePhone("987654321");
        model.setAddresAlias("Casa");
        return model;
    }
}

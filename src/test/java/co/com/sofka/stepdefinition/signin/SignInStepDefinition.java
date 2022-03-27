package co.com.sofka.stepdefinition.signin;

import co.com.sofka.model.createaccount.FullFormModel;
import co.com.sofka.model.signin.SignInCredentialsModel;
import co.com.sofka.stepdefinition.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.question.createaccount.SuccessfulRegister.successfulRegister;
import static co.com.sofka.question.signin.WrongPasswordError.wrongPasswordError;
import static co.com.sofka.stepdefinition.createaccount.CreateAccountStepDefinition.setModelData;
import static co.com.sofka.task.contactus.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.createaccount.EnterEmail.enterEmail;
import static co.com.sofka.task.createaccount.FillFullRegisterForm.fillFullRegisterForm;
import static co.com.sofka.task.createaccount.GoToSignInPage.goToSignInPage;
import static co.com.sofka.task.signin.LogIn.logIn;
import static co.com.sofka.task.signin.LogOut.logOut;
import static co.com.sofka.util.RandomEmailGenerator.randomEmail;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SignInStepDefinition extends Setup {
    private static final String ACTOR_NAME = "Cliente";
    private static String RANDOM_EMAIL;
    private static String WRONG_PASSWORD = "123451";
    private FullFormModel registerModel;
    private SignInCredentialsModel signInModel;

    @Given("El usuario se encuentra en la vista principal de la tienda")
    public void elUsuarioSeEncuentraEnLaVistaPrincipalDeLaTienda() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Given("el usuario navega al modulo de Sign In")
    public void elUsuarioNavegaAlModuloDeSignIn() {
        theActorInTheSpotlight().attemptsTo(
                goToSignInPage()
        );
    }

    @Given("El usuario se registra en la pagina correctamente")
    public void elUsuarioSeRegistraEnLaPaginaCorrectamente() {
        RANDOM_EMAIL = randomEmail();
        registerModel = setModelData();
        theActorInTheSpotlight().attemptsTo(
                enterEmail().UsingEmail(RANDOM_EMAIL),
                fillFullRegisterForm().usingModel(registerModel)
        );
    }

    @Given("el usuario cierra su sesion")
    public void elUsuarioCierraSuSesion() {
        theActorInTheSpotlight().attemptsTo(
            logOut()
        );
    }

    @When("el usuario ingresa sus credenciales de inicio correctas")
    public void elUsuarioIngresaSusCredencialesDeInicioCorrectas() {
        signInModel = new SignInCredentialsModel();
        signInModel.setEmail(RANDOM_EMAIL);
        signInModel.setPassword(registerModel.getPassword());
        theActorInTheSpotlight().attemptsTo(
                logIn().usinModel(signInModel)
        );
    }

    @Then("el sistema redirigira a la vista de cuenta de usuario")
    public void elSistemaRedirigiraALaVistaDeCuentaDeUsuario() {
        theActorInTheSpotlight().should(
                seeThat(successfulRegister(), equalTo(true))
        );
    }

    @When("el usuario ingresa el email registrado con una contrasenia incorrecta")
    public void elUsuarioIngresaElEmailRegistradoConUnaContraseniaIncorrecta() {
        signInModel = new SignInCredentialsModel();
        signInModel.setEmail(RANDOM_EMAIL);
        signInModel.setPassword(WRONG_PASSWORD);
        theActorInTheSpotlight().attemptsTo(
                logIn().usinModel(signInModel)
        );
    }

    @Then("el sistema mostrara un mensaje de autenticacion fallida")
    public void elSistemaMostraraUnMensajeDeAutenticacionFallida() {
        theActorInTheSpotlight().should(
                seeThat(wrongPasswordError(), equalTo(true))
        );
    }
}

package co.com.sofka.runner.signin;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepdefinition.signin"},
        features = {"src/test/resources/features/signin/signIn.feature"}
)
public class SignInTest {
}

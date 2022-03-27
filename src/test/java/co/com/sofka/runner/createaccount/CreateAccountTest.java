package co.com.sofka.runner.createaccount;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"co.com.sofka.stepdefinition.createaccount"},
        features = {"src/test/resources/features/createaccount/createAccount.feature"}
)
public class CreateAccountTest {
}

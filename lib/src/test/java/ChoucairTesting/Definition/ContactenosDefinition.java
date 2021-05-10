package ChoucairTesting.Definition;

import Steps.ContactenosSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ContactenosDefinition {
	
	@Steps
	ContactenosSteps contactenosSteps;
	
	@Given("^Abrir pagina web$")
	public void abrirPaginaWeb() {
		contactenosSteps.abrirNavegador();
	}


	@When("^llenar formulario de contactenos$")
	public void llenarFormularioDeContactenos() {
		contactenosSteps.formularioContactenos();
	}

	@Then("^validar el formulario$")
	public void validarElFormulario() {
		contactenosSteps.validacionFormulario();
	}

}

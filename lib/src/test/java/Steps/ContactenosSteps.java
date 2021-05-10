package Steps;

import PageObject.ContactenosPageObject;
import PageObject.LandingPageObject;
import net.thucydides.core.annotations.Step;

public class ContactenosSteps {
	
	LandingPageObject landing;
	ContactenosPageObject contactenos;
	
	@Step
	public void abrirNavegador() {
		landing.launchNav();
	}
	
	@Step
	public void formularioContactenos() {
		landing.clickContactenosBtn();
		try {
			Thread.sleep(5000);
			contactenos.llenarFormulario("Cinthia", "Bravo", "cinthiabravo88@outlook.com", "Bogotá", "Choucair", "3192488490", "cursos");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Step
	public void validacionFormulario() {
		try {
			contactenos.validacionFormulario();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

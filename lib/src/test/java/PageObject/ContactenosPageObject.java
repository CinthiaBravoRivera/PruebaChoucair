package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.PageObject;



public class ContactenosPageObject extends PageObject{
	
	private WebDriver driver =  this.getDriver();
	
	private String selectTema = "//h4[contains(text(),'Tema de interés')]/following::select[1]";
	private String inputNombre = "//input[@placeholder='Nombre']";
	private String inputApellidos = "//input[@placeholder='Apellidos']";
	private String inputCorreo = "//input[@placeholder='Correo electrónico']";
	private String inputCiudad = "//input[@placeholder='Ciudad']";
	private String inputEmpresa = "//input[@placeholder='Empresa']";
	private String inputCelular = "//input[@placeholder='Celular']";
	private String inputMensaje = "//h4[contains(text(),'Mensaje')]/following::textarea";
	private String checkPoliticas = "(//input[@type='checkbox' and @class='lp-form-fieldInput'])";
	private String enviarBtn = "//button[@name='submit']";
	private String graciasLbl = "//div[contains(text(),'¡Gracias por su envío!')]";
	
	
	public void llenarFormulario(String nombre, String apellidos, String correo,String ciudad, String empresa, String celular, String mensaje) throws InterruptedException {
		driver=getDriver();
		driver.switchTo().frame(0);
		new Select(driver.findElement(By.xpath(selectTema))).selectByVisibleText("Servicios y productos");
		driver.findElement(By.xpath(inputNombre)).sendKeys(nombre);
		driver.findElement(By.xpath(inputApellidos)).sendKeys(apellidos);
		driver.findElement(By.xpath(inputCorreo)).sendKeys(correo);
		driver.findElement(By.xpath(inputCiudad)).click();
		driver.findElement(By.xpath(inputCiudad)).sendKeys(ciudad);
		Thread.sleep(5000);
		driver.findElement(By.xpath(inputCiudad)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(inputCiudad)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(inputEmpresa)).sendKeys(empresa);
		driver.findElement(By.xpath(inputCelular)).sendKeys(celular);
		driver.findElement(By.xpath(inputMensaje)).sendKeys(mensaje);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000)");
		driver.findElement(By.xpath(checkPoliticas)).click();
		driver.findElement(By.xpath(enviarBtn)).click();
		
	}
	
	public void validacionFormulario() throws InterruptedException {
		Thread.sleep(1000);
		WebElement validacion = driver.findElement(By.xpath(graciasLbl));
		Assert.assertEquals("¡Gracias por su envío!", validacion.getText());
	}
	
	
	
}

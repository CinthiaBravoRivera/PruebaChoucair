package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.thucydides.core.pages.PageObject;

public class LandingPageObject extends PageObject{
	
	public WebDriver driver;
	
	private String serviceBtn = "//a[contains(text(),'Servicios')]";
	private String contactenosBtn = "//a[contains(text(),'Contáctenos')]";
	
	public static void main(String[] args) throws InterruptedException {
		LandingPageObject landing= new LandingPageObject();
		landing.launchNav();
		landing.clickContactenosBtn();
		Thread.sleep(5000);
		new ContactenosPageObject().llenarFormulario("Cinthia", "Bravo", "cinthiabravo88@outlook.com", "Bogotá", "Choucair", "3192488490", "cursos");
	}
	
	public void launchNav() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//		driverAux = new ChromeDriver();
//		setDriver(driverAux);
		driver= this.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
		
	}
	
	public void clickServiceBtn() {
		driver.findElement(By.xpath(serviceBtn)).click();
	}
	
	public void clickContactenosBtn() {
		driver.findElement(By.xpath(contactenosBtn)).click();
	}
	

}

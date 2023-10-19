package PageObjects;

import org.openqa.selenium.By;
import PageObjects.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Google {
    DriverManager driver;
    By btnRechazar = By.xpath("//div[text()='Rechazar todo']");
    By txtBuscador = By.xpath("//textarea[@aria-label='Buscar']");
    By linkWiki = By.xpath("//a[contains(text(),'Wikipedia')]");
    public Google(DriverManager driver) {
        this.driver = driver;
    }

    public void ClickRechazar(){
        driver.click(btnRechazar);
    }

    public void buscar(String txt){
        driver.writeText(txtBuscador, txt);
        driver.sendEnter(txtBuscador);
    }

    public void gotoWiki(){
        driver.click(linkWiki);
    }

    public DriverManager getDriver(){
        return this.driver;
    }
}

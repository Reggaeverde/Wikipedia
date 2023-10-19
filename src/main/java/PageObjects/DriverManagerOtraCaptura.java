package PageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.IOException;

import java.time.Duration;
import java.util.List;

public class DriverManagerOtraCaptura {
    private WebDriver driver;
    WebDriverWait wait;
    public DriverManagerOtraCaptura() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--ignore-certificate-errors");
        options.addArguments("acceptInsecureCerts");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--incognito");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--allow-cross-origin-auth-prompt");
        options.addArguments("--disable-cookie-encryption");
        options.addArguments("--disable-site-isolation-trials");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navegar(String url){
        driver.get(url);
    }

    public void cerrarNavegador(){
        driver.quit();
    }

    public By scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: \"center\"});", element);
        return by;
    }
    public void click(By elemento){
        wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
        scrollToElement(elemento);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento)).click();
    }

    public void writeText(By elemento, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento)).sendKeys(text);
    }

    public void sendEnter(By elemento) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento)).sendKeys(Keys.ENTER);
    }
    
    public String elementoConTexto(By elem, String texto){
        List<WebElement> elementos = driver.findElements(elem);
        String resultado = null;
        for (WebElement parrafo: elementos){
            if(parrafo.getText().contains(texto)) {
                resultado = parrafo.getText();
            }
        }
        return resultado;
    }
public void captura(String ruta) throws IOException {
    Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    String dir = System.getProperty("user.dir") + File.separator + "target";
    ImageIO.write(screenshot.getImage(), "jpg", new File(dir+ruta));
}
}


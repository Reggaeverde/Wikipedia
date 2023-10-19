package Tests;

import PageObjects.DriverManager;
import PageObjects.Google;
import PageObjects.Wikipedia;

public class TestAuto {
    public static void main(String[] args) throws Exception {
        DriverManager driver = new DriverManager();
        System.out.println("Accedemos a google");
        driver.navegar("https://www.google.es");
        Google google = new Google(driver);
        System.out.println("Pulsamos el botón Rechazar");
        google.ClickRechazar();
        System.out.println("Buscamos la palabra automatización");
        google.buscar("automatización");
        System.out.println("Pulsamos el enlace de Wikipedia");
        google.gotoWiki();
        Wikipedia wiki = new Wikipedia(google.getDriver());
        System.out.println("Buscamos en la pantalla las palabras 'primer proceso'");
        wiki.buscarTexto("primer proceso");
        driver.takeSnapShot("../../resources");
    }
}

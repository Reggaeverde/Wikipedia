package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

public class Wikipedia {
    By parrafo = By.xpath("//p");
    DriverManager driver;

    public Wikipedia(DriverManager driver) {
        this.driver = driver;
    }

    public void buscarTexto(String text){
        String pTexto = driver.elementoConTexto(parrafo,text);
        if(pTexto!= null){
            String[] frases =pTexto.split(Pattern.quote("."));
            for(int i =0; i<frases.length; i++){
                if(frases[i].contains(text)){
                    System.out.println(frases[i]);
                }
            }
        }else {
            System.out.println("No se ha encontrado la cadena '"+text+"' en la pantalla");
        }
    }
}

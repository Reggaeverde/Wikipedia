package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
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

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada" );

        //driver.quit();
    }
}
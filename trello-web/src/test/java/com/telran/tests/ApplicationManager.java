package com.telran.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;

  public void init() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.navigate().to("https://trello.com");
    login("elena.telran@yahoo.com", "12345.com");
  }


  public void stop() {
    driver.quit();
  }

}

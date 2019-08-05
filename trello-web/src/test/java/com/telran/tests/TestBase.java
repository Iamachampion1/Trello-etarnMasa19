package com.telran.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase  extends ApplicationManager{

  @BeforeClass
  public void setUp() throws InterruptedException {
    init();
  }

  @AfterClass
  public void tearDown(){
    stop();
  }

}

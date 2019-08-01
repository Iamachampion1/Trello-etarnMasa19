package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver driver;

  @BeforeClass
  public void setUp() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    driver.navigate().to("https://trello.com");
    login("elena.telran@yahoo.com", "12345.com");

  }

  public void login(String email, String password) throws InterruptedException {
    clickOnLoginButton();
    fillUserForm(email, password);
    confirmLoginButton();
    pause(10000);
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }

  public void confirmLoginButton() {
    click(By.id("login"));
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void fillUserForm(String email, String password) {
    type( By.id("user"), email);
    type(By.id("password"),password);


  }

  public void type(By locator , String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void clickOnLoginButton() {
    click(By.cssSelector("[href='/login']"));
  }

  @AfterClass
  public void tearDown(){
    driver.quit();
  }

  public void clickOnHomeButtonOnHeader() throws InterruptedException {
    pause(10000);
    click(By.cssSelector("a [name=house]"));
  }

  public void confirmBoardCreation() {
    click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
  }

  public void fillBoardCreationForm(String boardName) {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
  }

  protected void selectCreateBoardFromDropDown() {
    click(By.xpath("//*[@data-test-id='header-create-board-button']"));
  }

  protected void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }

  public void logout() {
    clickOnAvatar();
    clickLogout();
  }

  public void clickLogout() {
    click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
  }

  public void clickOnAvatar() {
    click(By.cssSelector(".js-open-header-member-menu"));
  }
}

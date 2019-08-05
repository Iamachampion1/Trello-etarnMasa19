package com.telran.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver driver;
  boolean acceptNextAlert = true;

  public void init() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

  public void stop() {
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
    if(isUserLoggedIn()){
      clickOnAvatar();
      clickLogout();
    }
  }

  public void clickLogout() {
    click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
  }

  public void clickOnAvatar() {
    click(By.cssSelector(".js-open-header-member-menu"));
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public void confirmTeamDeletionButton() {
    new WebDriverWait(driver, 15)
            .until(ExpectedConditions
                    .presenceOfElementLocated(By.cssSelector(".js-confirm")));
    click(By.cssSelector(".js-confirm"));
  }

  public void clickDeleteTeamLink() throws InterruptedException {
    Thread.sleep(15000);
    click(By.cssSelector(".quiet-button"));
  }

  public void clickOnTeamSettings() {
    click(By.cssSelector("a .icon-gear"));
  }

  public void clickOnFirstTeam() {
    click(By.cssSelector("[data-test-id='home-team-tab-name']"));
  }

  protected boolean isUserLoggedIn() {
    return isElementsPresent(By.cssSelector(".js-open-header-member-menu"));
  }

  private boolean isElementsPresent(By locator) {
    return driver.findElements(locator).size()>0;
  }

  public int getBoardsCount() {
    return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-2;
  }

  public int getTeamsCount() {

    WebElement teamsList = driver.findElement(By
            .cssSelector("nav.home-left-sidebar-container .js-react-root"));
    return teamsList.findElements(By.xpath(".//li")).size();
  }

  public int getTeamsCount2(){
    return driver.findElements(By
            .cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
  }
}

package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
  @BeforeMethod
public void preconditions(){
  logout();
}
  @Test
  public void loginTest() throws InterruptedException {
    String currentUrl = driver.getCurrentUrl();

    Assert.assertEquals(currentUrl, "https://trello.com/logged-out");

    clickOnLoginButton();
    fillUserForm("elena.telran@yahoo.com", "12345.com");
    confirmLoginButton();
    pause(4000);

    Assert.assertTrue(isUserLoggedIn());
  }

  private boolean isUserLoggedIn() {
    return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
  }

  private boolean isElementPresent(By locator) {
    return driver.findElements(locator).size()>0;
  }


}

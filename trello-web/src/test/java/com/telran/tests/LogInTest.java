package com.telran.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
  @BeforeMethod
public void preconditions(){
  app.logout();
}
  @Test
  public void loginTest() throws InterruptedException {
    String currentUrl = app.driver.getCurrentUrl();

    Assert.assertEquals(currentUrl, "https://trello.com/logged-out");

    app.clickOnLoginButton();
    app.fillUserForm("elena.telran@yahoo.com", "12345.com");
    app.confirmLoginButton();
    app.pause(4000);

    Assert.assertTrue(app.isUserLoggedIn());
  }


}

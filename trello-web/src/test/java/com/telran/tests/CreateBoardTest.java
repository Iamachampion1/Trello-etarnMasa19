package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateBoardTest  extends  TestBase{
  @Test
  public void boardCreationTest() throws InterruptedException {
    clickOnLoginButton();
    fillUserForm("elena.telran@yahoo.com", "12345.com");
    confirmLoginButton();
    pause(10000);


    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm();
    confirmBoardCreation();
    clickOnHomeButtonOnHeader();
  }

  private void selectCreateBoardFromDropDown() {
    click(By.xpath("//*[@data-test-id='header-create-board-button']"));
  }

  private void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }
}

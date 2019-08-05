package com.telran.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateBoardTest  extends  TestBase{
  @Test
  public void boardCreationTestFromHeader () throws InterruptedException {

int beforeCreation = app.getBoardsCount();
    app.clickOnPlusButtonOnHeader();
    app.selectCreateBoardFromDropDown();
    app.fillBoardCreationForm("Masa-" + System.currentTimeMillis());
    app.confirmBoardCreation();
    app.clickOnHomeButtonOnHeader();

    int afterCreation= app.getBoardsCount();

    System.out.println(beforeCreation + " : " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }



}

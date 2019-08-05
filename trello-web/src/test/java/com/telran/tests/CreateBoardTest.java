package com.telran.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateBoardTest  extends  TestBase{
  @Test
  public void boardCreationTest() throws InterruptedException {

int beforeCreation = getBoardsCount();
    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm("Masa-" + System.currentTimeMillis());
    confirmBoardCreation();
    clickOnHomeButtonOnHeader();

    int afterCreation= getBoardsCount();

    System.out.println(beforeCreation + " : " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }



}

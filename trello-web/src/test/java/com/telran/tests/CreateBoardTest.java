package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateBoardTest  extends  TestBase{
  @Test
  public void boardCreationTest() throws InterruptedException {

int beforeCreation = getBoardsCount();
    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm("Masa" + System.currentTimeMillis());
    confirmBoardCreation();
    clickOnHomeButtonOnHeader();

    int afterCreation= getBoardsCount();

    System.out.println(beforeCreation + " : " + afterCreation);

    Assert.assertEquals(afterCreation, beforeCreation +1);
  }

  public int getBoardsCount() {
    return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-2;
  }

}

package com.telran.tests;

import org.openqa.selenium.By;

public class HeaderPage extends  HelperBase{
  public void clickOnHomeButtonOnHeader() throws InterruptedException {
    pause(10000);
    click(By.cssSelector("a [name=house]"));
  }

  protected void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }
}

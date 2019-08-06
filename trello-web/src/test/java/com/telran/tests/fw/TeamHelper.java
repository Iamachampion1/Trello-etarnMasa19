package com.telran.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends  HelperBase {
  public TeamHelper(WebDriver driver) {
    super(driver);
  }

  public void confirmTeamDeletionButton() {
    new WebDriverWait(driver, 15)
            .until(ExpectedConditions
                    .presenceOfElementLocated(By.cssSelector(".js-confirm")));

    click(By.cssSelector(".js-confirm"));
  }

  public void clickDeleteTeamLink() throws InterruptedException {
    click(By.cssSelector(".quiet-button"));
  }

  public void clickOnTeamSettings() {
  click(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."));
  }

  public void clickOnFirstTeam() throws InterruptedException {
   pause(15000);
    click(By.cssSelector("[data-test-id='home-team-tab-name']"));
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

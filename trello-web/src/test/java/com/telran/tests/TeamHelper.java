package com.telran.tests;

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
    Thread.sleep(15000);
    click(By.cssSelector(".quiet-button"));
  }

  public void clickOnTeamSettings() {
    click(By.cssSelector("a .icon-gear"));
  }

  public void clickOnFirstTeam() {
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

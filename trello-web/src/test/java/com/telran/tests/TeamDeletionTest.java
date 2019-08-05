package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {

  @Test
  public void testTeamDeletion() throws InterruptedException {
    pause(15000);
    int before = getTeamsCount();
    System.out.print(before + " : ");
    clickOnFirstTeam();
    clickOnTeamSettings();
    clickDeleteTeamLink();
    confirmTeamDeletionButton();

    int after = getTeamsCount();
    System.out.println(after);



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

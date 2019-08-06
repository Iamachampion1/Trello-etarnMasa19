package com.telran.tests.test;


import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {

  @Test
  public void testTeamDeletion() throws InterruptedException {
  //  app.getSession().pause(15000);
    int before = app.getTeam().getTeamsCount();
    while (before>2) {
      System.out.println(before + " : ");
      app.getTeam().clickOnFirstTeam();
      app.getTeam().clickOnTeamSettings();
      app.getTeam().clickDeleteTeamLink();
      app.getTeam().confirmTeamDeletionButton();
      before = app.getTeam().getTeamsCount();
    }
    int after = app.getTeam().getTeamsCount();
    System.out.println(after);
  }


}

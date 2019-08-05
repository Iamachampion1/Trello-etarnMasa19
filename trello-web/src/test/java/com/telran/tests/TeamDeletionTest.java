package com.telran.tests;


import org.testng.annotations.Test;

public class TeamDeletionTest extends TestBase {

  @Test
  public void testTeamDeletion() throws InterruptedException {
    app.getSession().pause(15000);
    int before = app.getTeam().getTeamsCount();
    System.out.print(before + " : ");
    app.getTeam().clickOnFirstTeam();
    app.getTeam().clickOnTeamSettings();
    app.getTeam().clickDeleteTeamLink();
    app.getTeam().confirmTeamDeletionButton();

    int after = app.getTeam().getTeamsCount();
    System.out.println(after);
  }


}

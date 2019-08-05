package com.telran.tests;


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


}

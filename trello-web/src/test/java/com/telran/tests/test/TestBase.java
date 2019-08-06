package com.telran.tests.test;

import com.telran.tests.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

  public final ApplicationManager app
          = new ApplicationManager();

  @BeforeClass
  public void setUp() throws InterruptedException {
    app.init();
  }

  @AfterClass
  public void tearDown(){
    app.stop();
  }

}

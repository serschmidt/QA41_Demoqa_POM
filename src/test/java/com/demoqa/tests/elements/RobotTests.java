package com.demoqa.tests.elements;

import com.demoqa.pages.ElementsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getElements();
    new SidePanel(driver).selectUpload().hideIframes();
  }

  @Test
  public void perfomKeyEventsWithRobotTest() {
    new ElementsPage(driver).performKeyEventsWithRobot()
        .verfyPath("C:\\fakepath\\D1.txt");

  }

  @Test
  public void performMouseEventTests(){
    new ElementsPage(driver).performMouseEvent()
        .verfyPath("C:\\fakepath\\D1.txt");

  }
}

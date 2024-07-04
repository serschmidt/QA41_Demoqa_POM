package com.demoqa.tests.AlertsTests;

import com.demoqa.pages.AlertsFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedIframesTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getAlertFrameWindows();
    new SidePanel(driver).selectNestedFrames().hideIframes();

  }

  @Test
  public void handleNestedIframesTest(){
    new AlertsFrameWindowsPage(driver).handleNestedIframes();
  }

}

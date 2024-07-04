package com.demoqa.tests.AlertsTests;

import com.demoqa.pages.AlertsFrameWindowsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getAlertFrameWindows();
    new SidePanel(driver).selectFrames();
  }

  @Test
  public void framesTest() {
    new AlertsFrameWindowsPage(driver).getListOfIframes();
  }

  @Test
  public void switchToIframeByIndexTest(){
    new AlertsFrameWindowsPage(driver).switchToIframeByIndex(1)
        .verifyIframeText("This is a sample page");
  }

  @Test
  public void switchToIframeByIdTest(){
    new AlertsFrameWindowsPage(driver).switchToIframeById()
        .returnToMainContent()
        .verifyMainContentText("There are 2 Iframes in this page");
  }

}

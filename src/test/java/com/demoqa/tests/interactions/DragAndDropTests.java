package com.demoqa.tests.interactions;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.InteractionsPage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getInterations();
    new SidePanel(driver).selectDroppable().hideIframes();
  }

  @Test
  public void actionDragMeTest(){
    new InteractionsPage(driver).actionDragMeBy(20,50)
        .verifyDropped("Dropped!");
  }


}

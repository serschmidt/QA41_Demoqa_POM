package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InteractionsPage extends BasePage{

  public InteractionsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "draggable")
  WebElement dragMe;

  @FindBy(id = "droppable")
  WebElement dropHere;

  public InteractionsPage actionDragMe() {
    pause(1000);
    moveWithJS(dragMe,0,200);
    new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
    return this;
  }

  public InteractionsPage verifyDropped(String text) {
    Assert.assertTrue(shouldHaveText(dropHere,text,5));
    return this;
  }

  public InteractionsPage actionDragMeBy(int x, int y) {
    pause(1000);
    moveWithJS(dragMe,0,200);

    //  get Coordinates dropHere(to) and print
    int xOffset1 = dragMe.getLocation().getX();
    int yOffset1 = dragMe.getLocation().getY();
    System.out.println("x-->" + xOffset1 + "***" +
        "y-->" + yOffset1);

    int xOffset = dropHere.getLocation().getX();
    int yOffset = dropHere.getLocation().getY();
    System.out.println("x-->" + xOffset + "***" + "y-->" + yOffset);

    //find the Difference
    xOffset= (xOffset-xOffset1) + x;
    yOffset= (yOffset-yOffset1) + y;

    new Actions(driver).dragAndDropBy(dragMe,xOffset,yOffset).perform();
    return this;
  }
}

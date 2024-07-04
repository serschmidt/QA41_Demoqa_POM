package com.demoqa.tests.forms;

import com.demoqa.pages.FormsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StudentFormsTest extends TestBase {

  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getForms();
    new SidePanel(driver).selectPracticeForm().hideIframes();
  }

  @Test
  @Parameters({"firstName", "lastName", "email", "phone"})
  public void createStudentAccountPositiveTest(String firstName, String lastName, String email, String phone){
    new FormsPage(driver).enterPersonalData(firstName, lastName, email, phone)
        .selectGender("Male")
//        .enterDate("20 Feb 2002")
        .selectDate("August", "1997", "16")
        .selectSubjects(new String[]{"Maths", "Chemistry"})
        .selectHobbies(new String[]{"Sports", "Readings"})
        .uploadFile("C:/Tools/1.jpg")
        .selectState("NCR")
        .selectCity("Delhi")
        .submit()
        .verifySuccessRegistration("Thanks for submitting the form")
        ;
  }


}

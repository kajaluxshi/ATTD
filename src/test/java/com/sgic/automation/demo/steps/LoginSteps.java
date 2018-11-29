package com.sgic.automation.demo.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sgic.automation.demo.pages.DashboardPage;
import com.sgic.automation.demo.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {

  public static WebDriver driver;

  @Before
  public void setUpTest() {
    System.setProperty("webdriver.chrome.driver", "E:/Software/QA/chromedriver.exe");
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Given("^I have OrangeHRM applicaiton loaded$")
  public void i_have_OrangeHRM_applicaiton_loaded() throws Throwable { // we can change the method name it's not a matter
    driver.get("https://opensource-demo.orangehrmlive.com");                                                                    
  }

  @When("^I login with username \"([^\"]*)\" and pasword \"([^\"]*)\"$")
  public void i_login_with_username_and_pasword(String username, String password) throws Throwable {
   LoginPage loginPage=new LoginPage(driver);
   loginPage.validLogin(username, password);
   
  }

  @Then("^I should navigate to dashboard page$")
  public void i_should_navigate_to_dashboard_page() throws Throwable {
    DashboardPage dashboardPage=new DashboardPage(driver);
    Assert.assertTrue(dashboardPage.isDashboardDisplayed());
  }
  
  @Then("^I should get error message$")
  public void i_should_get_error_message(String ExpMessage) throws Throwable {
      LoginPage loginPage=new LoginPage(driver);
      Assert.assertEquals(ExpMessage, loginPage.getErrorMessage());
  }

}

// @Before,@After other two annotations of cucumber

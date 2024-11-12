package stepdefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.SignUpPage;

public class loginstep {
	
	static WebDriver driver;
	SignUpPage pobj = null;
	@Before
	@Given("The user is on the google chrome browser and application URL is opened")
	public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pobj = PageFactory.initElements(driver, SignUpPage.class);
    }

    @After
	public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
	public void The_user_is_on_the_google_chrome_browser_and_application_URL_is_opened() {
		System.out.println("Browser is opened");
       // AssertJUnit.assertNotNull(driver, "Driver should be initialized");
  
	}
    
	@Given("User enters URL and opens the application Home page through URL")
	public void user_enters_url_and_opens_the_application_home_page_through_url() {
		driver.navigate().to("https://www.demoblaze.com/");
        System.out.println("Application URL is entered");
      
	}
   
	@Then("The application Home page is displayed")
	public void the_application_home_page_is_displayed() {
		//AssertJUnit.assertNotNull(pobj, "Page object should be initialized");
        if (!pobj.homepagelogo_img.isDisplayed()) {
            System.out.println("Home page is not visible");
            AssertJUnit.fail("Home page logo is not displayed");
        }
        System.out.println("Application Home page is visible");
    }
	  
 //scenerio 2
// Scenario: To verify the User can access sign up Window    
    @Given("User is on the application Home page")
    public void user_is_on_the_application_home_page() {
    	driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        if (!driver.getTitle().equals("STORE")) {
            System.out.println("User is not on the application home page");
            AssertJUnit.assertTrue(false);
        } else {
            System.out.println("User is on the application home page");
        }
    }
    

    @When("User clicks on the signup link")
    public void user_clicks_on_the_signup_link() {
    	pobj.signup_link(); // Ensure `signup_link` is a valid method in SignUpPage class
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Signup link is clicked");  
    }

    @Then("The signup window is displayed")
    public void the_signup_window_is_displayed() 
     throws InterruptedException {


            if (!pobj.isSignUpWindowDisplayed()){ 
                System.out.println("Sign up window is not displayed");
                AssertJUnit.assertTrue(false);
            } else {
                System.out.println("Sign up window is visible");
            }  
    }

    @Then("All elements in the signup window are visible")
    public void all_elements_in_the_signup_window_are_visible() {
    	if (!pobj.username_input.isEnabled()) { 
            System.out.println("Username field is not visible");
            AssertJUnit.assertTrue(false);
        } else {
            System.out.println("Username field is visible");
        }

        if (!pobj.password_input.isEnabled()) { 
            System.out.println("Password field is not visible");
            AssertJUnit.assertTrue(false);
        } else {
            System.out.println("Password field is visible");
        }

        if (!pobj.signupclose_button.isEnabled())
        	
 { 
            System.out.println("Signup close button is not visible");
            AssertJUnit.assertTrue(false);
        } else {
            System.out.println("Signup close button is visible");
        }
    }
    
    // scenerio 3

@Then("Enters a valid username and password")
public void enters_a_valid_username_and_password() throws InterruptedException {
	
	Random r = new Random();
	int unoffset = r.nextInt(100);
	pobj.username_input.sendKeys("Rakhi" + unoffset);
	pobj.password_input.sendKeys("acs@123");

	Thread.sleep(2000);
}



@Then("clicks on the signup button")
public void clicks_on_the_signup_button() throws InterruptedException {
	Thread.sleep(2000);
	pobj.clickSignUpButton();
	Thread.sleep(2000);
	System.out.println("click signup of window");
}



@Then("User should be successfully registered")
public void user_should_be_successfully_registered() throws InterruptedException {
	try {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();

        if (msg.equals("Sign up successful.")) {
            System.out.println("Registeration is successful.");
            AssertJUnit.assertTrue(true);
        }
        else {
            System.out.println("User is not successful Registered.");
            System.out.println("Test case failed");
            AssertJUnit.fail("Unexpected alert message: " + msg);
        }
       // alert.accept(); // Close the alert after processing

    } catch (NoAlertPresentException e) {
        System.out.println("No alert present. " + e.getMessage());
        AssertJUnit.fail("Expected alert not present");
    }
}
    


@Then("A greeting message should be displayed")
public void a_greeting_message_should_be_displayed() {
	
	try {
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();

        if (msg.equals("Sign up successful.")) {
            System.out.println("Registeration is successful.");
            AssertJUnit.assertTrue(true);
        }
        else {
            System.out.println("User is not successful Registered.");
            System.out.println("Test case failed");
            AssertJUnit.fail("Unexpected alert message: " + msg);
        }
       // alert.accept(); // Close the alert after processing

    } catch (NoAlertPresentException e) {
        System.out.println("No alert present. " + e.getMessage());
        AssertJUnit.fail("Expected alert not present");
    }
}
//scenerio Outline

@Then("Enters a valid username(.+) and password(.+)$")
public void user_enters_valid_and(String username, String password) throws InterruptedException {
	pobj.username_input.clear();
	pobj.username_input.sendKeys(username);
	pobj.password_input.clear();
	pobj.password_input.sendKeys(password);
	System.out.println("Username:= " + username + ", Password: =" + password);
	Thread.sleep(3000);

}






//scenerio 4
@When("Enters existed username and valid password")
public void enters_existed_username_and_valid_password() throws InterruptedException {
	pobj.username_input.sendKeys("Rakhi");
	pobj.password_input.sendKeys("acs@123");
  System.out.println("Existing username and password");
	Thread.sleep(2000);
} 


@When("Click on signup button")
public void click_on_signup_button() throws InterruptedException {
	Thread.sleep(2000);
	pobj.clickSignUpButton();
	Thread.sleep(2000);
	System.out.println("click signup of window");
}   


@When("User credentials are wrong")
public void user_credentials_are_wrong() {
	System.out.println("Invalid credentials");
	
}
   


@Then("User should not be able to register into the application")
public void user_should_not_be_able_to_register_into_the_application() {
	try {
        Alert alert1 = driver.switchTo().alert();
        String msg = alert1.getText();

        if (!msg.equals("Sign up successful.")) {
            System.out.println("Registeration is unsuccessfil.");
//            Assert.assertTrue(false);
        }
        else {
            System.out.println("User successful Registered.");
           
           
        }
        alert1.accept(); // Close the alert after processing

    } catch (NoAlertPresentException e) {
        System.out.println("No alert present. " + e.getMessage());
        
    }

}  


@Then("An error message should be displayed for the existing username")
public void an_error_message_should_be_displayed_for_the_existing_username() {
	 try {
	        Alert alert2 = driver.switchTo().alert();
	        String msg = alert2.getText();

	        if (msg.equals("This user already exists.pz try  again")) {
	            System.out.println("Registeration is unsuccessfil.");
//	            Assert.assertTrue(false);
	        }
	        else {
	            System.out.println("User successful Registered.");
	           
	           
	        }
	        alert2.accept(); // Close the alert after processing

	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present. " + e.getMessage());
	        
	    }
	
	}  
}



     




    


    
    
    
	




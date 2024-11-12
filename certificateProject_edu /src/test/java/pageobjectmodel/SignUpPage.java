package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory elements
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for various elements on the sign-up page
    @FindBy(id = "nava")
    public WebElement homepagelogo_img;
//homepage signup button
    @FindBy(css = "#signin2")
    WebElement signUpLink;

    @FindBy(id = "signInModal")
    WebElement signup_window;

    @FindBy(xpath = "//input[@id='sign-username']")
	public
    WebElement username_input;

    @FindBy(id = "sign-password")
	public
    WebElement password_input;

   // @FindBy(xpath = "//button[text()='Sign up']")
  //button[@class='btn btn-primary']
//    @FindBy(xpath = "button[@class='btn btn-primary']") 
//    WebElement signUpButton;
    
    @FindBy(css = "button[onclick='register()']")
    WebElement signUpButton;
    //cssSelector("button[onclick='register()']")) window signup 

    @FindBy(css = ".btn.btn-secondary")
    public  WebElement signupclose_button;

    @FindBy(xpath = "//div[contains(text(), 'Sign up successful')]")
    WebElement registrationSuccessMessage;

    @FindBy(xpath = "//div[contains(text(), 'This user already exists.')]")
    WebElement existingUserErrorMessage;

    // Methods to interact with elements
    public void signup_link() {
    	signUpLink.click();
    
    }
    // Method to navigate to the home page and verify URL
    public boolean isHomePageDisplayed() {
        driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        System.out.println("Application URL is entered");
        return driver.getCurrentUrl().equals("https://www.demoblaze.com");
    }

    // Method to check if the sign-up window is displayed
    public boolean isSignUpWindowDisplayed(){
        return signup_window.isDisplayed();
    	
    }

    // Method to check if all elements in the sign-up window are visible
    public boolean isSignUpFormElementsVisible() {
        return username_input.isDisplayed() && password_input.isDisplayed()&& signUpButton.isDisplayed();
    }

    // Methods to interact with the sign-up form fields
    public void enterUsername(String username) {
    	username_input.clear();
    	username_input.sendKeys(username);
    }

    public void enterPassword(String password) {
    	password_input.clear();
    	password_input.sendKeys(password);
    }

    // Click sign-up button for signup window
    public void clickSignUpButton() {
    	signUpButton.click();
    }

    // Close the sign-up window
    public void closeSignUpWindow() {
        signupclose_button.click();
    }

    // Check if registration was successful
    public boolean isRegistrationSuccessful() {
        return registrationSuccessMessage.isDisplayed();
    }

    // Check if the "user already exists" error is displayed
    public boolean isUserAlreadyExistsErrorDisplayed() {
        return existingUserErrorMessage.isDisplayed();
    }
}


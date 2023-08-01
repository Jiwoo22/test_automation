package com.solvd.carina.demo.gui.components;

import com.solvd.carina.demo.gui.components.header.HeaderMenu;
import com.solvd.carina.demo.gui.pages.desktop.HomePage;
import com.solvd.carina.demo.gui.pages.desktop.LoginPage;
import com.solvd.carina.demo.utils.UserService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class LoginForm extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(HeaderMenu.class.getName());

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement inputPassword;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    public LoginForm(WebDriver driver, SearchContext context) {
        super(driver, context);
        setUiLoadedMarker(loginForm);
    }

    public boolean isLoginFormPresent() {
        LOGGER.info("Checking if login from is displayed");
        return loginForm.isElementPresent();
    }

    public HomePage login(UserService user){
        inputEmail.type(user.getUser().getEmail());
        inputPassword.type(user.getUser().getPassword());
        return submitLogin();
    }

    public HomePage submitLogin() {
        submitButton.click();
        LOGGER.info("Login performed");
        return new HomePage(getDriver());
    }

    public LoginPage loginWithInvalidEmail(UserService user) {
        inputEmail.type(user.getUserWithInvalidEmail().getEmail());
        inputPassword.type(user.getUserWithInvalidEmail().getPassword());
        submitButton.click();
        LOGGER.info("Login is not performed due to invalid email");
        return new LoginPage(getDriver());
    }

    public LoginPage loginWithInvalidPassword(UserService user) {
        inputEmail.type(user.getUserWithInvalidPassword().getEmail());
        inputPassword.type(user.getUserWithInvalidPassword().getPassword());
        submitButton.click();
        LOGGER.info("Login is not performed due to invalid password");
        return new LoginPage(getDriver());
    }
}
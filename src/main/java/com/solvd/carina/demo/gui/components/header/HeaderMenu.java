package com.solvd.carina.demo.gui.components.header;


import com.solvd.carina.demo.gui.components.LoginForm;
import com.solvd.carina.demo.gui.enums.HeaderIconLink;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class HeaderMenu extends HeaderMenuBase {

    private static final Logger LOGGER = Logger.getLogger(HeaderMenu.class.getName());

    @FindBy(id = "login-popup2")
    public LoginForm loginForm;

    @FindBy(xpath = "//button[contains(@class, 'line-button minus)]")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement logo;

    @FindBy(id = "topsearch")
    private ExtendedWebElement topSearch;

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement loginIcon;

    @FindBy(css = ".head-icon.icon-user-plus")
    private ExtendedWebElement signUpIcon;

    @FindBy(xpath = "//a[@id='login-active']//span[@class='icon-count'][text()='test.user']")
    private ExtendedWebElement userName;

    @FindBy(xpath = "//div[@id='social-connect']//i[contains(@class, '%s')]")
    private ExtendedWebElement headerIcon;


    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickHeaderMenuIcon(HeaderIconLink headerIconLink) {
        LOGGER.info("Clicking on " + headerIconLink.getValue() + " icon");
        headerIcon.format(headerIconLink.getValue()).click();
    }

    public boolean isHeaderMenuIconPresent(HeaderIconLink headerIconLink) {
        LOGGER.info("Clicking on " + headerIconLink.getValue() + " icon");
        return headerIcon.format(headerIconLink.getValue()).isElementPresent();
    }

    public boolean isLoginIconPresent() {
        LOGGER.info("Checking if login icon is present");
        return loginIcon.isElementPresent(3);
    }

    public LoginForm openLoginForm() {
        LOGGER.info("opening login form");
        return loginForm;
    }

    public void clickOnBurgerMenu() {
        LOGGER.info("Clicking on burger menu");
        burgerMenu.click();
    }

    public void enterTopSearch(String searchQuery) {
        LOGGER.info("Entering search query");
        topSearch.type(searchQuery);
    }

    public String getUserName() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(userName.getBy()), 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        LOGGER.info((String) js.executeScript("return document.querySelectorAll('.icon-count', ':before')[6].textContent"));
        return (String) js.executeScript("return document.querySelectorAll('.icon-count', ':before')[6].textContent");
    }
}

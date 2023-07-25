package com.solvd.carina.demo.gui.components.header;


import com.solvd.carina.demo.gui.components.LoginForm;
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

    @FindBy(css = ".lines-button.minus")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement logo;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement topSearch;

    @FindBy(css = ".head-icon")
    private ExtendedWebElement tipUsIcon;

    @FindBy(css = ".head-icon.icon-soc-youtube")
    private ExtendedWebElement youtubeIcon;

    @FindBy(css = ".head-icon.icon-instagram")
    private ExtendedWebElement instagramIcon;

    @FindBy(css = ".head-icon.icon-soc-rss2")
    private ExtendedWebElement rssIcon;

    @FindBy(css = ".head-icon.icon-specs-car")
    private ExtendedWebElement carSpecsIcon;

    @FindBy(css = ".head-icon.icon-cart")
    private ExtendedWebElement cartIcon;

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement loginIcon;

    @FindBy(css = ".head-icon.icon-user-plus")
    private ExtendedWebElement signUpIcon;

    @FindBy(css = ".icon-count")
    private ExtendedWebElement userName;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLoginIconPresent() {
        LOGGER.info("Checking if login icon is present");
        return loginIcon.isElementPresent(3);
    }

    public LoginForm openLoginForm() {
        LOGGER.info("opening login form");
        loginIcon.click();
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

    public void clickOnTipUsIcon() {
        LOGGER.info("Clicking on TipUs icon");
        tipUsIcon.click();
    }

    public void clickOnInstagramIcon() {
        LOGGER.info("Clicking on Instagram icon");
        instagramIcon.click();
    }

    public void clickOnYoutubeIcon() {
        LOGGER.info("Clicking on Youtube icon");
        youtubeIcon.click();
    }


    public void clickOnRssIcon() {
        LOGGER.info("Clicking on RSS icon");
        rssIcon.click();
    }

    public String getUserName() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(userName.getBy()), 100);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        LOGGER.info((String) js.executeScript("return document.querySelectorAll('.icon-count', ':before')[6].textContent"));
        return (String) js.executeScript("return document.querySelectorAll('.icon-count', ':before')[6].textContent");
    }
}

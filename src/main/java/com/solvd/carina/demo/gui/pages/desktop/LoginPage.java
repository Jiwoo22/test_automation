package com.solvd.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath="//div[@class='normal-text res-error']//child::p")
    private ExtendedWebElement textLoginFail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessege() {
        LOGGER.info("Login result [" + textLoginFail.getText() + "]");
        return textLoginFail.getText();
    }

    public boolean isMessagePresent(String message) {
        return textLoginFail.getText().equals(message);
    }

}

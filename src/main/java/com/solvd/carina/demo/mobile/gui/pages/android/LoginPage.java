package com.solvd.carina.demo.mobile.gui.pages.android;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @FindBy(id = "name")
    private ExtendedWebElement nameInputField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "radio_male")
    private ExtendedWebElement maleRadioBtn;

    @FindBy(id = "radio_female")
    private ExtendedWebElement femaleRadioBtn;

    @FindBy(id = "checkbox")
    private ExtendedWebElement privacyPolicyCheckbox;

    @FindBy(id = "login_button")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeName(String name) {
        nameInputField.type(name);
        hideKeyboard();
    }

    @Override
    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    @Override
    public void selectMaleSex() {
        maleRadioBtn.click();
    }

    @Override
    public void selectFemaleSex() {
        femaleRadioBtn.click();
    }

    @Override
    public void checkPrivacyPolicyCheckbox() {
        privacyPolicyCheckbox.click();
    }

    @Override
    public CarinaDescriptionPageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), CarinaDescriptionPageBase.class);
    }

    @Override
    public boolean isLoginBtnActive() {
        return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
    }

    @Override
    public CarinaDescriptionPageBase login() {
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);
        typeName(username);
        typePassword(password);
        selectMaleSex();
        checkPrivacyPolicyCheckbox();
        return clickLoginBtn();
    }

    public boolean isNameInputFieldPresent(){
        return nameInputField.isPresent();
    }

    public boolean isPasswordInputFieldPresent(){
        return passwordInputField.isPresent();
    }

    public boolean isMaleRadioBtnPresent(){
        return maleRadioBtn.isPresent();
    }

    public boolean isFemaleRadioBtnPresent(){
        return femaleRadioBtn.isPresent();
    }

    public boolean isPrivacyPolicyCheckboxPresent(){
        return privacyPolicyCheckbox.isPresent();
    }

    public boolean isPrivacyPolicyChecked() {
        return privacyPolicyCheckbox.isChecked();
    }
    public boolean isPrivacyPolicyUnchecked() {
        return !privacyPolicyCheckbox.isChecked();
    }

    public boolean isMaleRadioBtnChecked() {
        return maleRadioBtn.isChecked();
    }
    public boolean isMaleRadioBtnUnchecked() {
        return !maleRadioBtn.isChecked();
    }

    public boolean isFemaleRadioBtnChecked() {
        return femaleRadioBtn.isChecked();
    }
    public boolean isFemaleRadioBtnUnchecked() {
        return !femaleRadioBtn.isChecked();
    }

}

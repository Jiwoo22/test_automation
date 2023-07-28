package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.android.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.UIElementsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.solvd.carina.demo.utils.MobileContextUtils.View;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MobileCarinaTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "jiwoo choi")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void verifyLoginPage(){
        String username = "Test user";
        String password = RandomStringUtils.randomAlphabetic(10);

        // 1. Open login page
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened");
        LoginPage loginPage = (LoginPage) welcomePage.clickNextBtn();

        // 2. verify if all the fields are presented and unchecked
        Assert.assertTrue(loginPage.isNameInputFieldPresent(), "Name input field is not present");
        Assert.assertTrue(loginPage.isPasswordInputFieldPresent(), "Password input field is not present");
        Assert.assertTrue(loginPage.isMaleRadioBtnPresent(), "Male button is not present");
        Assert.assertTrue(loginPage.isFemaleRadioBtnPresent(), "Female button is not present");
        Assert.assertTrue(loginPage.isPrivacyPolicyCheckboxPresent(), "Privacy policy checkbox is not present");
        Assert.assertTrue(loginPage.isMaleRadioBtnUnchecked(), "Male button is checked");
        Assert.assertTrue(loginPage.isFemaleRadioBtnUnchecked(), "Female button is checked");
        Assert.assertTrue(loginPage.isPrivacyPolicyUnchecked(), "Privacy policy checkbox is checked");

        // 3. type name, password
        loginPage.typeName(username);
        loginPage.typePassword(password);

        // 4. female is checked
        loginPage.selectFemaleSex();

        // 5. tap privacy policy checkbox
        loginPage.checkPrivacyPolicyCheckbox();

        // 6. click signup button -> user is logined, Web View page is opened
        CarinaDescriptionPageBase carinaDescriptionPage = loginPage.clickLoginBtn();
        Assert.assertTrue(carinaDescriptionPage.isPageOpened(), "Carina description page isn't opened");

    }
}

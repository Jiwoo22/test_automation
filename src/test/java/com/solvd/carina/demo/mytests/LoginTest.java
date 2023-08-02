package com.solvd.carina.demo.mytests;

import com.solvd.carina.demo.gui.components.LoginForm;
import com.solvd.carina.demo.gui.enums.HeaderIconLink;
import com.solvd.carina.demo.gui.pages.desktop.HomePage;
import com.solvd.carina.demo.gui.pages.desktop.LoginPage;
import com.solvd.carina.demo.utils.User;
import com.solvd.carina.demo.utils.UserService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    @Test(description = "Login scenario", dataProvider = "login scenario")
    @MethodOwner(owner = "jiwoo")
    public void testLoginResult(User user, String message) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        LoginPage loginPage = loginForm.login(user);
        if (!message.equals("")) {
            Assert.assertEquals(loginPage.getErrorMessege(),message, "Unexpected login result");
        } else {
            pause(1);
            Assert.assertEquals(homePage.getHeaderMenu().getUserName(), R.TESTDATA.get("nickname"),"failed login");
        }
    }

    @DataProvider(parallel = true, name = "login scenario")
    public Object[][] dataProviderLogin() {
        return new Object[][]{
                {new UserService().getUser(), ""},
                {new UserService().getUserWithInvalidEmail(), "Reason: User record not found."},
                {new UserService().getUserWithInvalidPassword(), "Reason: Wrong password."}
        };
    }
}

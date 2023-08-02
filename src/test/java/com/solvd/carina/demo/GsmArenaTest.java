//package com.solvd.carina.demo;
//
//
//import com.solvd.carina.demo.gui.components.LoginForm;
//import com.solvd.carina.demo.gui.components.header.HeaderMenu;
//import com.solvd.carina.demo.gui.pages.desktop.HomePage;
//import com.solvd.carina.demo.gui.pages.desktop.LoginPage;
//import com.solvd.carina.demo.utils.UserService;
//import com.zebrunner.carina.core.AbstractTest;
//import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
//import com.zebrunner.carina.utils.R;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class GsmArenaTest extends AbstractTest {
//
//    private static final String GSM_ARENA_LOGIN_FAILED_EMAIL = "Reason: User record not found.";
//    private static final String GSM_ARENA_LOGIN_FAILED_PASSWORD = "Reason: Wrong password.";
//
//    @Test(description = "Verify login component")
//    @MethodOwner(owner = "Jiwoo")
//    public void verifyLoginComponent(){
//
//        // Open GSM Arena home page and verify page is opened
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");
//
//        // Verify login icon from header
//        HeaderMenu headerMenu = homePage.getHeaderMenu();
//        Assert.assertTrue(headerMenu.isLoginIconPresent(), "Login icon is not present");
//    }
//
//
//    @Test(description = "Verify Success Login")
//    @MethodOwner(owner = "Jiwoo Choi")
//    public void testSuccessLogin() {
//
//        UserService userCreation = new UserService();
//
//        // Open GSM Arena home page and verify page is opened*/
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page is not open");
//
//        // Verify login form
//        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
////        Assert.assertTrue(loginForm.isLoginFormPresent() , "Login form is not present");
//
//        // Test login
//        HomePage homePageAfterLogin = loginForm.login(userCreation);
//        Assert.assertEquals(homePageAfterLogin.getHeaderMenu().getUserName(), R.TESTDATA.get("nickname"),"failed login");
//    }
//
//
//    @Test(description = "Verify Login with wrong email")
//    public void testLoginWithWrongEmail() {
//
//        UserService userCreation = new UserService();
//
//        // Open GSM Arena home page and verify page is opened*/
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        homePage.assertPageOpened();
//
//        // Verify login form
//        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
////        Assert.assertTrue(loginForm.isLoginFormPresent(), "Login form is not present");
//
//        // Test login with wrong email
//        LoginPage loginPage = loginForm.loginWithInvalidEmail(userCreation);
//        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_EMAIL, "Password is not wrong");
//    }
//
//
//    @Test(description = "Verify Login with wrong password")
//    public void testLoginWithWrongPassword() {
//
//        UserService userCreation = new UserService();
//
//        // Open GSM Arena home page and verify page is opened*/
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        homePage.assertPageOpened();
//
//        // Verify login form
//        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
////        Assert.assertTrue(loginForm.isLoginFormPresent(), "Login form is not present");
//
//        // Test login with wrong email
//        LoginPage loginPage = loginForm.loginWithInvalidPassword(userCreation);
//        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_PASSWORD, "Password is not wrong");
//    }
//}

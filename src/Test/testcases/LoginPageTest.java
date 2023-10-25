package Test.testcases;

import Main.base.TestBase;
import Main.pages.HomePage;
import Main.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        System.out.println("Title of Page is:---> " + title);
        Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest(){
        homePage = loginPage.login("brijesh", "12345678");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

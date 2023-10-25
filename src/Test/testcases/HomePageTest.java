package Test.testcases;

import Main.base.TestBase;
import Main.pages.ContactsPage;
import Main.pages.HomePage;
import Main.pages.LoginPage;
import Main.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    //test cases should be separated -- independent with each other
    //before each test case -- launch the browser and login
    //@test -- execute test case
    //after each test case -- close the browser

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login("brijesh", "12345678");
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homepageTitle = homePage.verifyHomePageTitle();
        System.out.println("Title of the Page is: ----> " + homepageTitle);
        Assert.assertEquals(homepageTitle,"CRMPRO" , "HomePage Title does not match!!");
    }

    @Test(priority = 2)
    public void verifyCorrectUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

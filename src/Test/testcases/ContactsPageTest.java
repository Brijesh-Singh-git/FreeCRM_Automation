package Test.testcases;

import Main.base.TestBase;
import Main.pages.ContactsPage;
import Main.pages.HomePage;
import Main.pages.LoginPage;
import Main.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public  ContactsPageTest(){
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
        testUtil.switchToFrame();
        homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
    }

    @Test(priority = 2)
    public void selectSingleContactsTest(){
        contactsPage.selectContactsByName("Priya Rajput");
    }

    @Test(priority = 3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactsByName("Rohan Das");
        contactsPage.selectContactsByName("Aanchal Malhotra");
    }

//    @DataProvider
//    public void getTestData(){
//
//    }
    @Test(priority = 4)
    public void validateCreateNewContactTest(){
        homePage.clickOnNewContactLink();
        contactsPage.createNewContact("Mr.", "David", "Bellick", "Microsoft");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

package Main.pages;

import Main.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "surname")
    WebElement lastName;

    @FindBy(name = "client_lookup")
    WebElement companyName;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveBtn;



    public ContactsPage(){
        PageFactory.initElements(driver, this);
    }


    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }


    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//td[@class='datalistrow']/a[text()='"+name+"']//" +
                "parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void createNewContact(String title , String fName, String lName, String companyname){
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        companyName.sendKeys(companyname);
        saveBtn.click();

    }

















}

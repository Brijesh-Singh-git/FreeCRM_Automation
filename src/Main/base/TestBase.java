package Main.base;

import Main.util.TestUtil;
import Main.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;


import Main.util.WebEventListener ;


public class TestBase {
    public static WebDriver driver;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        this.driver = driver;
    }


    public static void initialization() {

        System.setProperty("Webdriver.edge.driver", "Drivers/msedgedriver.exe");
        driver = new EdgeDriver();


//        e_driver = new EventFiringWebDriver(driver);
//        // Now create object of EventListerHandler to register it with EventFiringWebDriver
//        eventListener = new WebEventListener();
//        e_driver.register(eventListener);
//        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get("https://classic.freecrm.com/index.html");

    }
}

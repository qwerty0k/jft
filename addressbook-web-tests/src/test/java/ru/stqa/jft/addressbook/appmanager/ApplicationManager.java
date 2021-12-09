package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;


public class ApplicationManager {
    WebDriver driver;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.FIREFOX.browserName())) {
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox esr\\firefox.exe");
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox esr\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals(Browser.EDGE.browserName())) {
            System.setProperty("webdriver.edge.bin", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            System.setProperty("webdriver.msedge.driver", "D:\\jft\\addressbook-web-tests\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}

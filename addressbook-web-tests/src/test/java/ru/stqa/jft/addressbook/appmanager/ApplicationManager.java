package ru.stqa.jft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    FirefoxDriver driver;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;

    public void init() {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox esr\\firefox.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox esr\\geckodriver.exe");
       driver = new FirefoxDriver();
       driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
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
}

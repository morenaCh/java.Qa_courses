package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver wd;
    private String browser;

    public ContactHelper contact;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper; //metoda do ktorej delegujemy 1.link do klasy delegowanej
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties=new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        dbHelper=new DbHelper();

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);//metoda do ktorej delegujemy 2.inicjalizacja drivera
        contact = new ContactHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPassword"));

    }

    public void stop() {
        sessionHelper().logout();
        wd.quit();
    }

    public void switchTo() {
        wd.switchTo().alert().accept();
    }

    public ContactHelper contact() {
        return contact;
    }

    public GroupHelper group() { //metoda do ktorej delegujemy 2.musimy metode do ktorej delegujemy tutaj zwrocic;
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper sessionHelper() {
        return sessionHelper;
    }

    public DbHelper db(){return dbHelper;}


}

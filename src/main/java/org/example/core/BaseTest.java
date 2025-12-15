package org.example.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BaseTest {

    protected static final String baseUrl = "https://rozetka.com.ua/";

    @BeforeMethod
    public void setUp() {
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;

        Selenide.open(baseUrl);
        getWebDriver().manage().window().maximize();
        Selenide.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

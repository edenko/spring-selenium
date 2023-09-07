package com.example.medium.Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class index {

    @GetMapping("/test/rss/medium")
    public void getDataMedium() {
        String geckoDriverPath = "/home/ubuntu/test/geckodriver";
//        String geckoDriverPath = "/Users/commoncoding/Downloads/firfox-driver/geckodriver";

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("-- disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://medium.com/illumination/sonar-for-soil-how-we-can-use-sound-to-save-our-farms-and-forests-8521ebf86bb8");
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            System.out.println(img.getAttribute("src"));
        }
    }
}

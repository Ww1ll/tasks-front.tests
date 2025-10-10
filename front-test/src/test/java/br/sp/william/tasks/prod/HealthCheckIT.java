package br.sp.william.tasks.prod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class HealthCheckIT {

    @Test
    public void healthCheck() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try{


        driver.navigate().to("http://192.168.0.211:9999/tasks/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String version = driver.findElement(By.id("version")).getText();

        Assert.assertTrue(version.startsWith("build"));

        } finally {
            driver.quit();
        }

    }
}

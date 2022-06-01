/*
Domaći:
Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.
Domaći na git.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @Test
    public void testDesktop() {
        WebElement desktop=driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktop.click();
        WebElement desktopScrolled=driver.findElement(By.id("desktop"));
        String expectedTextDesktop="Desktop";
        String actualTextDesktop=desktopScrolled.getText();
        Assert.assertEquals(expectedTextDesktop,actualTextDesktop);
    }


    @Test
    public void testMobile(){
        WebElement mobile= driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobile.click();
        WebElement mobileScrolled=driver.findElement(By.id("mobile"));
        String expectedTextMobile="Mobile";
        String actualTextMobile=mobileScrolled.getText();
        Assert.assertEquals(expectedTextMobile,actualTextMobile);
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

}

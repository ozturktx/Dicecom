package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class diceJobSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        String url="https://www.dice.com/";
        driver.get(url);

        String searchField="search-field-keyword";
        String location="search-field-location";

        ArrayList<String>jobs=new ArrayList<String>();
        jobs.add("Automation Engineer");
        driver.findElement(By.id(searchField)).sendKeys(jobs.get(0));
        driver.findElement(By.id(location)).sendKeys("77084");
        driver.findElement(By.id(location)).clear();
        driver.findElement(By.id(location)).sendKeys("77084");

        driver.findElement(By.id("findTechJobs")).click();
    String expectedTitle=jobs.get(0);
    String actualTitle=driver.getTitle();
    if(actualTitle.contains(expectedTitle))
        System.out.println("Title test is passed");
    else
    {
        System.out.println("Title is failed");
        System.out.println("expectedTitle "+expectedTitle);
        System.out.println("Actual Title "+actualTitle);
    }

    driver.findElement(By.xpath("//input[@chkval='Houston, TX']")).click();

        String foundJobs=driver.findElement(By.id("posiCountId")).getText();
        System.out.println("Found Jobs "+foundJobs+ "for "+jobs.get(0)+" in 77084 Houston");
    }

}

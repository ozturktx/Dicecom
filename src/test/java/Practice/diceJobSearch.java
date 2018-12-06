package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        String expectedTitle="Find Jobs in Tech";
        String actualTitle=driver.getTitle();
        if(actualTitle.contains(expectedTitle))
            System.out.println("Title test is passed");
        else
        {
            System.out.println("Title is failed");
            System.out.println("expectedTitle "+expectedTitle);
            System.out.println("Actual Title "+actualTitle);
        }
        String searchField="job";
        String location="location";

        ArrayList<String>searchItems=new ArrayList<String>();
        searchItems.add("Automation Engineer");
       searchItems.add("Java developer");
        searchItems.add("Selenium");
        searchItems.add("C#");
        searchItems.add("Cucumber");
        searchItems.add("Tester");
        searchItems.add("Designer");
        driver.findElement(By.id("findTechJobs")).click();

        WebElement searchButton=(driver.findElement(By.xpath("//input[@value='Find Tech Jobs']")));

        driver.findElement(By.id(location)).clear();
        driver.findElement(By.id(location)).sendKeys("TX");
        for(int i=0;i<searchItems.size();i++)
        {
            driver.findElement(By.id(searchField)).clear();
           // driver.findElement(By.id(location)).clear();
            //Thread.sleep(2000);
            driver.findElement(By.id(searchField)).sendKeys(searchItems.get(i));
            driver.findElement(By.xpath("//input[@value='Find Tech Jobs']")).click();
            String foundJobs=driver.findElement(By.id("posiCountId")).getText();
            String renew=searchItems.get(i)+"----"+foundJobs;
            searchItems.set(i,renew);


        }
        //driver.findElement(By.id(searchField)).sendKeys(searchItems.get(0));

       // driver.findElement(By.id(location)).clear();


     //   driver.findElement(By.id("findTechJobs")).click();

        System.out.println(searchItems+"/n");
    }

}

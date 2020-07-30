package google;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import company.Company;
import company.FiscalYear;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Email {

    public static void verifyEmail() {
        int confirmation = JOptionPane.showConfirmDialog(null, "Verify email draft and click send", "Validate email", JOptionPane.DEFAULT_OPTION);
    }

    public void createDrafts(ArrayList<Company> listOfCompanies, String user, String password, String website) throws Exception {

        // selenium & webdriver setup
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\christian.saldana\\Downloads\\Passport\\Passport\\Resources\\win_chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);


        //login to gmail
        Thread.sleep(3000); // 3 seconds
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(user);
        driver.findElement(By.cssSelector("div[id=identifierNext]")).click();
        Thread.sleep(3000); // 3 seconds
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div[id=passwordNext]")).click();
        Thread.sleep(10000); // 10 seconds

        for (Company co : listOfCompanies) {

            //click on compose and add the to mail id, and subject
            driver.findElement(By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3")).click();
            Thread.sleep(3000); // 3 seconds
            driver.findElement(By.xpath("//span[@class='aB gQ pE']")).click(); // click on cc 	

            driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys(co.clientEmail); // enter email
            Thread.sleep(3000); // 3 seconds
            driver.findElement(By.xpath("//textarea[@name='cc']")).sendKeys(co.cc); // enter cc
         
            Thread.sleep(3000); // 3 seconds
            driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']")).sendKeys(co.subject);
            Thread.sleep(3000); // 3 seconds
            //driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']")).sendKeys(Keys.TAB);

            // email body
            //FiscalYear fy = new FiscalYear();
            //String text = "Greetings " + co.client + " , please review the report for " + fy.getCurrentMonth() +"-" + fy.getCurrentYear();
           
            driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(co.tbody);
            
            /* StringSelection stringSelection = new StringSelection(co.tbody);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);*/

            //click on attachment
            Thread.sleep(3000); // 3 seconds
            //driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();

            driver.findElement(By.xpath("//img[@class='Ha']")).click();
            Thread.sleep(3000); // 3 seconds

            //use autoit tool to attach a file
            //Runtime.getRuntime().exec("C:\\Users\\christian.saldana\\Downloads\\Passport\\Passport\\Resources\\fileUpload.exe " + co.attachment);
            //Thread.sleep(10000); //wait for 10sec to upload file
            //verifyEmail();
        }

        driver.close();
    }
}

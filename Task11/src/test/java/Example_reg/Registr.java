package Example_reg;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class Registr {
    private WebDriver driver;
    private WebDriverWait wait;
public String Email()
{

    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(calendar.HOUR_OF_DAY);
    int minute = calendar.get(calendar.MINUTE);
    int second = calendar.get(calendar.SECOND);
    String email= "Sobol_" +hour+"_"+minute+"_"+second+"@mail.ru";
    return email;

}
    @Before
    public void start(){
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,1000);
    }
    @Test
    public void myFirstTest() throws InterruptedException {
        driver.get("http://localhost/litecart/en/");

        Thread.sleep(500);
        WebElement Element = driver.findElement(By.id("box-account-login"));
        Element = Element.findElement(By.cssSelector("a"));
        Element.click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name = 'firstname']")).sendKeys("Anastasiya");
        driver.findElement(By.cssSelector("input[name = 'lastname']")).sendKeys("Sobol");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name = 'address1']")).sendKeys("Belgorod, st.Street 1");
        driver.findElement(By.cssSelector("input[name = 'postcode']")).sendKeys("11111");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input[name = 'city']")).sendKeys("Belgorod");
        driver.findElement(By.cssSelector("td span.select2-selection__arrow")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("United States", Keys.ENTER);
        String email = Email();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+11111111111");
        driver.findElement(By.name("newsletter")).click();
        Thread.sleep(500);
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmed_password")).sendKeys("password");
        driver.findElement(By.name("create_account")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
        Thread.sleep(500);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("login")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#box-account li:last-child a")).click();
        Thread.sleep(500);
    }
    @After
    public void stop(){

        driver.quit();
        driver = null;
    }
}

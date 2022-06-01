import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Zadatak1 {
    private WebDriver driver;

    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivana\\Desktop\\Bootcamp\\novChrome\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.telerik.com/support/demos");

    }

    @Test
    public void testDesktop () {
        WebElement desktopBtn = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopBtn.click();

        String expectedResult = "Desktop";
        String actualResult = driver.findElement(By.id("desktop")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMobile () {
        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobile.click();

        String actualRes = driver.findElement(By.id("mobile")).getText();
        String expectedRes = "Mobile";
        Assert.assertEquals(actualRes,expectedRes);
    }

    @AfterClass
    public void afterMethod(){
        driver.close();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

/**
 * Created by Administrator on 2017/5/10.
 */
public class FilteEnterprise {

    public void filteEnt(WebDriver driver) throws InterruptedException {
        WebElement webElement = null;
        MysqlConnect mysqlConnect = new MysqlConnect();
        String name = mysqlConnect.mysqlConn("SELECT id,name,count(1) FROM yunmap GROUP BY name having count(1) > 1 LIMIT 1");

        driver.get("http://192.168.2.204:8084/");
        Thread.sleep(500);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='searchParamType']")));
        select.selectByValue("name");

        webElement = driver.findElement(By.xpath("//input[@id='searchParam']"));
        webElement.sendKeys(name);

        webElement = driver.findElement(By.xpath("//button[@id='searchButton']"));
        webElement.click();
        Thread.sleep(2500);

        webElement = driver.findElement(By.xpath("//th[@class='t1']/label/input[@id='checkEntIdMoreUp']"));
        webElement.click();
        Thread.sleep(500);

        webElement = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[@name='id']"));
        webElement.click();
        Thread.sleep(500);

        webElement = driver.findElement(By.xpath("//button[@id='deleteEnt']"));
        webElement.click();
        Thread.sleep(500);

        webElement = driver.findElement(By.xpath("//div[@class='layui-layer-btn']/a[@class='layui-layer-btn0']"));
        webElement.click();
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
    }

    public void testActivity( WebDriver driver){

        Cookie cookie = new Cookie("userphone","18775242571","/",null);

        driver.manage().addCookie(cookie);

        Set<Cookie> cookies = driver.manage().getCookies();

        driver.get("http://127.0.0.1:8180/");

        driver.close();
    }

}

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2017/5/10.
 */
public class MySelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = FirefoxUtils.getFirefoxDriver();

        FilteEnterprise filteEnterprise = new FilteEnterprise();
        /*云图删除重复企业*/
//        for(int i = 0; i < 1365; i++){
//            filteEnterprise.filteEnt(driver);
//        }

        /*测试活动网页*/
        filteEnterprise.testActivity(driver);

        driver.close();
    }


}

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by Administrator on 2017/5/10.
 */
public class FirefoxUtils {
    public static FirefoxDriver getFirefoxDriver(String path) {
        File pathToBinary = new File(path);
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        return new FirefoxDriver(firefoxBinary, firefoxProfile);
    }

    /**
     * 设置默认Firefox路径，返回FirefoxDriver
     *
     * @return FirefoxDriver
     */
    public static FirefoxDriver getFirefoxDriver() {
        return FirefoxUtils.getFirefoxDriver("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
    }
}

package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class DriverFactory {
    private static WebDriver instance;
    private DriverFactory() {}

    private static HashMap<String, Supplier<WebDriver>> DRIVERS = new HashMap<String, Supplier<WebDriver>>() {{
        put("chrome", () -> {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        });
    }};

    public static WebDriver GetDriver() {
        if (Objects.isNull(instance))
            instance = DRIVERS.get("chrome").get();
        return instance;
    }

    public static WebDriver generateNewDriver(String type) {
            return DRIVERS.get(type).get();
    }
}

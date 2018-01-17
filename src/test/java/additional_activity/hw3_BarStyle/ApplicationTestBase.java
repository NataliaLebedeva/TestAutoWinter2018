package additional_activity.hw3_BarStyle;

import additional_activity.hw3_BarStyle.Application;
import org.testng.annotations.BeforeClass;

public class ApplicationTestBase {
    public static ThreadLocal<Application> applicationThreadLocal = new ThreadLocal<>();
    public Application app;

    @BeforeClass
    public void start() {
        if (applicationThreadLocal.get() != null) {
            app = applicationThreadLocal.get();
            return;
        }

        app = new Application();
        applicationThreadLocal.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    app.quit();
                    app = null;
                })
        );
    }

}

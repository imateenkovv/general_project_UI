package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

/**
 * @author mateenkov
 */

public class WebDriverProvider {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void configuration() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        String remoteUrl = config.getRemoteURL();

        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }
    }
}

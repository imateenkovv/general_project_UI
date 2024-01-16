package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Constants.*;

/**
 * @author mateenkov
 */

public class FakerUtils {
    Faker faker = new Faker(Locale.US);
    private static final String[] GAME_NAME_ARG = {
            FIREWATCH,
            TRUCK,
            CS
    };

    private static final String[] LOGIN_NAME_FRIEND = {
            "mateenkov93",
            "SuslikStas496",
            "tolkachev88"
    };

    public String getGameName() {
        return faker.options().option(GAME_NAME_ARG);
    }

    public String getLoginNameFriends() {
        return faker.options().option(LOGIN_NAME_FRIEND);
    }

}

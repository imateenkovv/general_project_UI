package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @author mateenkov
 */

public class FakerUtils {
    Faker faker = new Faker(Locale.US);
    private  static final String FIREWATCH = "Firewatch";
    private static final String TRUCK = "Euro Truck Simulator 2";
    private static final String CS = "Counter-Strike: Source";
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

package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @author mateenkov
 */

public class FakerUtils {
    public static Faker faker = new Faker(Locale.US);

    private static final String[] GAME_NAME_ARG ={
            "Firewatch",
            "Detroit: Become Human",
            "Counter-Strike: Source"
    } ;

    private static final String[] LOGIN_NAME_FRIEND ={
            "mateenkov93",
            "SuslikStas496",
            "tolkachev88"
    } ;

    public static String getGameName(){
        return faker.options().option(GAME_NAME_ARG);
    }

    public static String getLoginNameFriends(){
        return faker.options().option(LOGIN_NAME_FRIEND);
    }

}

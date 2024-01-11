package test;

import com.codeborne.selenide.Selenide;
import driver.BaseLocalTest;
import org.junit.jupiter.api.Test;

import static helpers.Constants.BASE_URL;

/**
 * @author mateenkov
 */

public class FirstTest extends BaseLocalTest {

    @Test
    void firstTest(){
        Selenide.open(BASE_URL);
    }

}

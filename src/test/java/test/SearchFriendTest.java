package test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CommunityPage;
import pages.MainPage;
import utils.FakerUtils;

/**
 * @author mateenkov
 */

public class SearchFriendTest extends BaseTest {
    MainPage mainPage = new MainPage();
    CommunityPage communityPage = new CommunityPage();
    FakerUtils faker = new FakerUtils();
    private final String LOGIN_FRIEND = faker.getLoginNameFriends();

    @Test
    @Tag("Web")
    @DisplayName("Поиск друга в Steam")
    @Severity(SeverityLevel.CRITICAL)
    public void searchFriendTest() {
        communityPage.openPage()
                .searchFriend(LOGIN_FRIEND)
                .checkFoundFriend(LOGIN_FRIEND);
    }
}

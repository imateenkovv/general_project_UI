package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CommunityPage;
import pages.MainPage;
import utils.FakerUtils;

import static helpers.Constants.COMMUNITY_URL;

/**
 * @author mateenkov
 */

public class SearchFriendTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    CommunityPage communityPage = new CommunityPage();
    static FakerUtils faker = new FakerUtils();
    private  final static String LOGIN_FRIEND = faker.getLoginNameFriends();

    @Test
    @DisplayName("Поиск друга в Steam")
    public void searchFriendTest(){

        mainPage.openPage(COMMUNITY_URL);
        communityPage.searchFriend(LOGIN_FRIEND)
                .checkFoundFriend(LOGIN_FRIEND);

    }

}

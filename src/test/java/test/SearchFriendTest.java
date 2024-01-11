package test;

import driver.BaseLocalTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CommunityPage;
import pages.MainPage;

import static helpers.Constants.COMMUNITY_URL;
import static utils.FakerUtils.getLoginNameFriends;

/**
 * @author mateenkov
 */

public class SearchFriendTest extends BaseLocalTest {
    MainPage mainPage = new MainPage();
    CommunityPage communityPage = new CommunityPage();
    private  final static String LOGIN_FRIEND = getLoginNameFriends();

    @Test
    @DisplayName("Поиск друга в Steam")
    public void searchFriendTest(){

        mainPage.openPage(COMMUNITY_URL);
        communityPage.searchFriend(LOGIN_FRIEND)
                .checkFoundFriend(LOGIN_FRIEND);

    }

}

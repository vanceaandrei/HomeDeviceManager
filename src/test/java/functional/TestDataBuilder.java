package functional;

import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 11/7/2016.
 */
public class TestDataBuilder {


    public static User createValidUser() {

        User user = new User();
        user.setUsername("TestUsername");
        user.setPassword("TestPassword");
        user.setEmail("TestEmail@test.test");
        user.setName("TestName");
        user.setSurname("TestSurname");

        return user;
    }

    public static User createInvalidUser() {
        User user = new User();
        user.setUsername("TestUsername");
//        user without password set
//        user.setPassword("TestPassword");
        user.setEmail("TestEmail");
        user.setName("TestName");
        user.setSurname("TestSurname");

        return user;
    }

    public static User createUserForDuplicateEmailTestCase() {
        User user = new User();
        user.setUsername("TestUsername2");
        user.setPassword("TestPassword2");
        user.setEmail("TestEmail2");
        user.setName("TestName2");
        user.setSurname("TestSurname2");

        return user;
    }

    public static List<User> createUsersForLoginTestCase() {

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setUsername("TestUsername1");
        user.setPassword("TestPassword1");
        user.setEmail("TestEmail1@test1.test1");
        user.setName("TestName");
        user.setSurname("TestSurname");

        users.add(user);

        return users;
    }
}

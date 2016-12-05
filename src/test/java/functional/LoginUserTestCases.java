package functional;

import exception.AuthValidationException;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import persistence.user.UserFactory;
import validation.AuthValidator;

import java.util.List;

/**
 * Created by andrei.vancea on 11/7/2016.
 */
public class LoginUserTestCases {

    public List<User> userAccounts;

    @Before
    public void setUp() throws Exception {
        userAccounts = TestDataBuilder.createUsersForLoginTestCase();
        prepareTestUsers();
    }

    @Test
    public void loginWithGoodCredentialsTestCase() {
        User user = userAccounts.get(0);
        try {
            AuthValidator.validateUserForLogin(user);
            User dbUser = UserFactory.getUserRepository().getUser(user.getUsername());
            BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
            if (decoder.matches(user.getPassword(), dbUser.getPassword())) {
                Assert.assertTrue(true);
            } else {
                // user doesn't exist in dataBase
                Assert.fail("user password doesn't match");
            }
        } catch (AuthValidationException e) {
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        removeTestUsers();
    }


    private void prepareTestUsers() {
        //clean test rows from DB if there are any
        for (User user : userAccounts) {
            UserFactory.getUserRepository().deleteUser(user.getEmail());
        }
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        for (User user : userAccounts) {
            User userToSave = new User(user.getName(), user.getSurname(), user.getEmail(), user.getUsername(), user.getPassword());
            userToSave.setPassword(decoder.encode(userToSave.getPassword()));
            UserFactory.getUserRepository().registerUser(userToSave);
        }
    }

    private void removeTestUsers() {
        for (User user : userAccounts) {
            UserFactory.getUserRepository().deleteUser(user.getEmail());
        }
    }
}

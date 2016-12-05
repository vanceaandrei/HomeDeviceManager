package functional;

import exception.AuthValidationException;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import persistence.user.UserFactory;
import validation.AuthValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 11/7/2016.
 */
public class RegisterUserTestCases {

    private List<User> usersToBeCreated;

    private void prepareData() {
        usersToBeCreated = new ArrayList<>();
        usersToBeCreated.add(TestDataBuilder.createValidUser()); //add valid user
        usersToBeCreated.add(TestDataBuilder.createInvalidUser()); //add invalid user
        usersToBeCreated.add(TestDataBuilder.createUserForDuplicateEmailTestCase());
        //remove all users
        UserFactory.getUserRepository().deleteUser(usersToBeCreated.get(0).getEmail());
        UserFactory.getUserRepository().deleteUser(usersToBeCreated.get(1).getEmail());
        UserFactory.getUserRepository().deleteUser(usersToBeCreated.get(2).getEmail());
        //register user for duplicate email test case
        UserFactory.getUserRepository().registerUser(usersToBeCreated.get(2));

    }

    @Before
    public void setUp() throws Exception {
        prepareData();
    }

    @Test
    public void createValidUserTestCase() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = usersToBeCreated.get(0); //valid user
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            AuthValidator.validateUserForRegister(user);
            //save user into DB
            UserFactory.getUserRepository().registerUser(user);
            Assert.assertTrue(true);
            UserFactory.getUserRepository().deleteUser(usersToBeCreated.get(0).getEmail());
        } catch (DataAccessException dae) {
            Assert.fail("Could not connect to database: " + dae);
        } catch (AuthValidationException e) {
            Assert.fail("Wrong User Data!!!");
        }
    }

    @Test
    public void createUserWithSameEmailTestCase() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = usersToBeCreated.get(0); //valid user
        //preCreate user
        UserFactory.getUserRepository().registerUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            AuthValidator.validateUserForRegister(user);

            //save user into DB
            UserFactory.getUserRepository().registerUser(user);
            Assert.fail("Exception expected to be thrown!!!");
        } catch (DataAccessException dae) {
            Assert.assertTrue(true);
            UserFactory.getUserRepository().deleteUser(usersToBeCreated.get(0).getEmail());
        } catch (AuthValidationException e) {
            Assert.fail("Wrong User Data!!!");
        }
    }

    @Test
    public void createInvalidUserTestCase() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = usersToBeCreated.get(1); //invalid user
        try {
            AuthValidator.validateUserForRegister(user);
            Assert.fail("Exception expected to be thrown!!!");
            user.setPassword(encoder.encode(user.getPassword()));
            //save user into DB
            UserFactory.getUserRepository().registerUser(user);

        } catch (DataAccessException dae) {
            Assert.fail("Could not connect to database: " + dae);
        } catch (AuthValidationException e) {
            Assert.assertTrue(true);
        }
    }

}

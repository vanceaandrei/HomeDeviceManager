package validation;

import exception.AuthValidationException;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

/**
 * Created by andrei.vancea on 9/26/2016.
 */
public class AuthValidator {

    public static void validateUserForRegister(User user) throws AuthValidationException {
        boolean isValid = true;
        if (user.getUsername() == null || user.getUsername().length() == 0) {
            isValid = false;
        }
        if (user.getName() == null || user.getName().length() == 0) {
            isValid = false;
        }
        if (user.getEmail() == null || user.getEmail().length() == 0 || !user.getEmail().contains("@")) {
            isValid = false;
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            isValid = false;
        }
        if (user.getSurname() == null || user.getSurname().length() == 0) {
            isValid = false;
        }

        if (!isValid) {
            throw new AuthValidationException("Invalid User");
        }
    }

    public static void validateUserForLogin(User user) throws AuthValidationException {

        boolean isValid = true;
        if (user.getUsername() == null || user.getUsername().length() == 0) {
            isValid = false;
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            isValid = false;
        }

        if (!isValid) {
            throw new AuthValidationException("Bad login credentials!!!");
        }

    }
}

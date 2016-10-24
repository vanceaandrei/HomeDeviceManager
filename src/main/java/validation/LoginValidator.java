package validation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

/**
 * Created by andrei.vancea on 9/26/2016.
 */
public class LoginValidator {


    public static String validateUser(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        if (decoder.matches(encodedPassword, rawPassword)) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

}

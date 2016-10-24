package persistence.user.api;

import models.User;

import java.util.Map;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public interface IUserRepository {

    User getUser(String username);

    void registerUser(User user);
}

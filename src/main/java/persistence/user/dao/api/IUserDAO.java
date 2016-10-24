package persistence.user.dao.api;

import models.User;

import java.util.Map;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public interface IUserDAO {

    User getUser(String username);

    int registerUser(User user);
}

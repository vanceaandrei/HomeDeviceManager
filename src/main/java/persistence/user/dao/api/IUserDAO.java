package persistence.user.dao.api;

import models.Device;
import models.User;

import java.util.List;
import java.util.Map;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public interface IUserDAO {

    User getUser(String username);

    int registerUser(User user);

    int deleteUser(String email);

    List<Device> getUserDevices(String email);
}

package persistence.user.api;

import models.Device;
import models.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Map;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public interface IUserRepository {

    User getUser(String username);

    void registerUser(User user);

    void deleteUser(String email);

    List<Device> getUserDevices(String email);
}

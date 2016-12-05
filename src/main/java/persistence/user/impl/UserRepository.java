package persistence.user.impl;

import models.Device;
import models.User;
import persistence.user.api.IUserRepository;
import persistence.user.dao.api.IUserDAO;

import java.util.List;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public class UserRepository implements IUserRepository {

    private IUserDAO userDAO;

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Get a user by username
     *
     * @param username
     * @return user
     */
    public User getUser(String username) {

        return getUserDAO().getUser(username);

    }

    /**
     * Register a user
     *
     * @param user
     */
    @Override
    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

    @Override
    public void deleteUser(String email) {
        userDAO.deleteUser(email);
    }

    @Override
    public List<Device> getUserDevices(String email) {
        return userDAO.getUserDevices(email);
    }
}

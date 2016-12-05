package persistence.user.dao.impl;

import models.Device;
import models.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import persistence.user.dao.api.IUserDAO;
import persistence.user.dao.impl.mapper.UserMapper;
import util.Const;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrei.vancea on 9/22/2016.
 */
public class UserDAO extends NamedParameterJdbcDaoSupport implements IUserDAO {

    private String loginUser;
    private String registerUserQuery;
    private String deleteUserQuery;
    private String userDevicesQuery;

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setRegisterUserQuery(String registerUserQuery) {
        this.registerUserQuery = registerUserQuery;
    }

    public String getRegisterUserQuery() {
        return registerUserQuery;
    }

    public void setDeleteUserQuery(String deleteUserQuery) {
        this.deleteUserQuery = deleteUserQuery;
    }

    public String getDeleteUserQuery() {
        return deleteUserQuery;
    }

    public void setUserDevicesQuery(String userDevicesQuery) {
        this.userDevicesQuery = userDevicesQuery;
    }

    public String getUserDevicesQuery() {
        return userDevicesQuery;
    }

    public User getUser(String username) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.DB_USERNAME, username);
        return getNamedParameterJdbcTemplate().queryForObject(getLoginUser(), params, new UserMapper());
    }

    @Override
    public int registerUser(User user) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.DB_NAME, user.getName());
        params.put(Const.DB_SURNAME, user.getSurname());
        params.put(Const.DB_EMAIL, user.getEmail());
        params.put(Const.DB_USERNAME, user.getUsername());
        params.put(Const.DB_PASSWORD, user.getPassword());
        return getNamedParameterJdbcTemplate().update(getRegisterUserQuery(), params);
    }

    @Override
    public int deleteUser(String email) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.DB_EMAIL, email);
        return getNamedParameterJdbcTemplate().update(getDeleteUserQuery(), params);
    }

    @Override
    public List<Device> getUserDevices(String email) {
        Map<String, String> params = new HashMap<>();
        params.put(Const.DB_EMAIL, email);
        List<Device> devices = new ArrayList<>();
        List<Map<String, Object>> response = getNamedParameterJdbcTemplate().queryForList(getUserDevicesQuery(), params);
        for (Map<String, Object> device : response) {
            devices.add(new Device(String.valueOf(device.get("name")), String.valueOf(device.get("description"))));
        }
        return devices;
    }


}
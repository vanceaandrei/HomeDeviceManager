package persistence.user.dao.impl.mapper;

import models.User;
import org.springframework.jdbc.core.RowMapper;
import util.Const;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andrei.vancea on 9/26/2016.
 */
public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User entry = new User();
        //entry.setName(rs.getString(Const.DB_NAME));
        //entry.setSurname(rs.getString(Const.DB_SURNAME));
        entry.setEmail(rs.getString(Const.DB_EMAIL));
        entry.setUsername(rs.getString(Const.DB_USERNAME));
        entry.setPassword(rs.getString(Const.DB_PASSWORD));
        return entry;
    }
}

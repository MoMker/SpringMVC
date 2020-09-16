package USER.Dao.Impl;

import USER.Dao.UserDao;
import USER.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User Findall() {
        String sql = "select * from users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper);
        return user;
    }

    @Override
    public User Findpsd(String name) {
        String sqls = "select * from users where username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sqls, rowMapper,name);
        return user;
    }

    @Override
    public User doInsert(String username, String password) {
        String sql = "insert into users(username,password) values (?,?)";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper,username,password);
        return user;
    }

}

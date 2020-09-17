package USER.Dao.Impl;

import USER.Dao.UserDao;
import USER.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select * from user_list";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> list = jdbcTemplate.query(sql, rowMapper);
        return list;
    }

    @Override
    public User findUser(User user) {
        String sqls = "select * from user_list where username = ? and password = ?";
        Object[] params = {user.getUsername(), user.getPassword()};
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User userA = jdbcTemplate.queryForObject(sqls, params, rowMapper);
        return userA;
    }

    @Override
    public void doInsert(User user) {
        String sql = "insert into user_list(username,password) values(?,?)";
        Object[] params = {user.getUsername(), user.getPassword()};
        jdbcTemplate.update(sql, params);
    }

}

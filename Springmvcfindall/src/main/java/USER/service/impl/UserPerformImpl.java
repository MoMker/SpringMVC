package USER.service.impl;

import USER.Dao.UserDao;
import USER.POJO.User;
import USER.service.UserPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPerformImpl implements UserPerform {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) throws Exception {
        try {
            return userDao.findUser(user);
        }catch (Exception e){
            throw new Exception("该用户不存在");
        }
    }

    @Override
    public void register(User user) {
        userDao.doInsert(user);
    }

    @Override
    public List<User> allUser() {
        return userDao.findAll();
    }
}

package USER.service;

import USER.POJO.User;

import java.util.List;

public interface UserPerform {
    User login(User user) throws Exception;
    void register(User user);
    List<User> allUser();
}

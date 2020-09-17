package USER.Dao;

import USER.POJO.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface UserDao {
   List<User> findAll();
   User findUser(User user);
   void doInsert(User user);
}

package USER.Dao;

import USER.POJO.User;
import org.springframework.web.servlet.ModelAndView;

public interface UserDao {
   User Findall();
   User Findpsd(String name);
    User doInsert(String username,String password);
}

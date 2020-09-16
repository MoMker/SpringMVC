package USER.Controller;

import USER.POJO.User;
import USER.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("user")
public class Ucontroller {
    @Autowired
     private UserDao userDao;
     @RequestMapping("/findall")
     @ResponseBody
    public ModelAndView Findall(){
        User user = userDao.Findall();
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("username",user.getUsername());
         modelAndView.addObject("password",user.getPassword());
         modelAndView.setViewName("/index.jsp");
         return modelAndView;
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public User doUser(@RequestParam(value = "username") String name){
        User users = userDao.Findpsd(name);
        return users;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String doInsert(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
         userDao.doInsert(username,password);
         return "findall";
    }
}

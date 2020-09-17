package USER.Controller;

import USER.POJO.User;
import USER.service.UserPerform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("user")
public class Ucontroller {
    @Autowired
    private UserPerform userPerform;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String doUser(@RequestBody User user, HttpSession session){
        try {
            User user1 = userPerform.login(user);
            session.setAttribute("user", user1);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping(value = "/weblogin",method = RequestMethod.GET)
    public String doUserInWeb(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpSession session){
        try {
            User user = new User(username, password);
            User user1 = userPerform.login(user);
            session.setAttribute("user", user1);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String doInsert(@RequestBody User user){
         userPerform.register(user);
         return "Success";
    }
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllUser(){
        return userPerform.allUser();
    }
}

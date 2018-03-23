package test.shop.controller;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import test.shop.Utils.MailUtils;
import test.shop.model.User;
import test.shop.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.19  17:16
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Value("${curbName}")
    private String curbName;


    @RequestMapping("/test")
    public String test()throws Exception{

        return "index";
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public Integer checkUser(@RequestParam String username)throws Exception{

        username = new String(username.getBytes("iso8859-1"),"utf-8");

        Integer user = loginService.findUserByUsername(username);
        if(user == 1){
            return 1;
        }
        return 0;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(User user)throws Exception{

        user.setUsername(new String(user.getUsername().getBytes("iso8859-1"),"utf-8"));

        String code = loginService.saveUser(user);

        return code;
    }

    @RequestMapping("/ln")
    public String login(@RequestParam String username, @RequestParam String password,
                         HttpServletRequest request)throws Exception{

        username = new String(username.getBytes("iso8859-1"),"utf-8");

        boolean code = loginService.findUserByName(username,password);

        if(username.equals(curbName)){
            HttpSession session = request.getSession();
            session.setAttribute(curbName,username);

        }


        if(code){

            return "redirect:/shop/list";

        }

            return null;
    }


}

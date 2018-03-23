package test.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import test.shop.dao.LoginMapper;
import test.shop.model.User;
import test.shop.service.LoginService;
import org.springframework.util.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.20  13:18
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;


    @Override
    public Integer findUserByUsername(String username) {

        Integer user = loginMapper.findUserByUsername(username);

        return user;
    }

    @Override
    public String saveUser(User user) {

        Integer u = findUserByUsername(user.getUsername());

        String s=user.getUsername();//目标字符串
        String userRegex="^[^\\s]*$";//正则表达式 判断用户名
        Pattern p=Pattern.compile(userRegex);
        Matcher m=p.matcher(s);

        String s2=user.getEmail();
        String emailRegex="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p2=Pattern.compile(emailRegex);
        Matcher m2=p2.matcher(s2);

        if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword()) ||
                StringUtils.isEmpty(user.getEmail())
                ){
            return "1";
        }else if(u != 0){
            return "2";
        }else if(!m.matches()){
            return "1";
        }else if(!m2.matches()){
            return "1";
        }else if(!(user.getRepassword().equals(user.getPassword()))){
            return "1";
        }else {


            String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

            user.setPassword(md5Pass);

            loginMapper.saveUser(user);

            return "0";
        }
    }

    @Override
    public boolean findUserByName(String username, String password) {

        User user = loginMapper.findUserByName(username);

        /*if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            // 如果不正确，返回登录失败
            return "1";
        }*/

        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());

        if(user == null){
            return false;
        }else if(!(md5Pass.equals(user.getPassword()))){
            return false;
        }else{
            return true;
        }



    }
}

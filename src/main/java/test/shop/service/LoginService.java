package test.shop.service;

import test.shop.model.User;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.20  13:18
 */
public interface LoginService {

    public Integer findUserByUsername(String username);

    public String saveUser(User user);

    public boolean findUserByName(String username,String password);

}

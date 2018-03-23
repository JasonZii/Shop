package test.shop.dao;

import test.shop.model.User;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.15  12:37
 */
public interface IUserDao {

    User selectUser(long id);
}

package test.shop.dao;

import org.apache.ibatis.annotations.Param;
import test.shop.model.User;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.20  13:17
 */
public interface LoginMapper {

    public Integer findUserByUsername(String username);

    public void saveUser(User user);

    public User findUserByName(@Param("username")String username);

}

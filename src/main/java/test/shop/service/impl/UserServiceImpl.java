package test.shop.service.impl;

import org.springframework.stereotype.Service;
import test.shop.dao.IUserDao;
import test.shop.model.User;

import javax.annotation.Resource;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.15  12:38
 */
@Service
public class UserServiceImpl {

    @Resource
    private IUserDao userdao;

    public User selectUser(long userId){
        return userdao.selectUser(userId);
    }

}

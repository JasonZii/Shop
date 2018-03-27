package test.shop.service;

import org.springframework.stereotype.Service;
import test.shop.model.Page;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.25  22:46
 */

public interface SearchService {

    //加入域
    boolean importAllShops();

    Page searchPage(String keyword,int page,int rows) throws Exception;

}

package test.shop.dao;

import test.shop.model.SearchShop;
import test.shop.model.Shopper;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.25  22:40
 */
public interface SearchMapper {

    List<SearchShop> getShopList();
}

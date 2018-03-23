package test.shop.service;

import test.shop.model.QueryVo;
import test.shop.model.ShopData;
import test.shop.model.Shopper;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  18:38
 */
public interface ShopperService {

     List<Shopper> findShopperByVo(QueryVo vo);


     Integer findShopperByVoCount(QueryVo vo);





     Shopper findShopperById(Long id);

     ShopData findShopDataById(Long id);

     void updateShopDataById(ShopData shopData);

     void deleteShopDataById(Long id);

     void addShop(ShopData shopData);

     Integer findAllCount();


}

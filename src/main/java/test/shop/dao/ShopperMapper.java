package test.shop.dao;

import org.apache.ibatis.annotations.Param;
import test.shop.model.QueryVo;
import test.shop.model.ShopData;
import test.shop.model.Shopper;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  18:11
 */
public interface ShopperMapper {

    public List<Shopper> findShopperByVo(QueryVo vo);

    public List<Shopper> curbFindShopperByVo(QueryVo vo);

    public Integer findShopperByVoCount(QueryVo vo);

    public Integer curbFindShopperByVoCount(QueryVo vo);


    public Shopper findShopperById(Long id);

    public ShopData findShopDataById(Long id);

    public void updateShopDataById(ShopData shopData);

    public void deleteShopDataById(Long id);

    public void addShopper(ShopData shopData);

    public Integer findAllCount();

    public Integer curbFindAllCount(String curbType);

    public Integer findSumMoneyByType(@Param("beginDate") String beginDate,
                                    @Param("endDate")String endDate,
                                    @Param("shopType")String shopType
    );

    public Integer findALLSumMoneyByDate(@Param("beginDate") String beginDate,
                                         @Param("endDate")String endDate
    );


    public Integer findLastInsertId();
}

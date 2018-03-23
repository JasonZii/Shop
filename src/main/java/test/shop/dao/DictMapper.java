package test.shop.dao;

import test.shop.model.BaseDict;
import test.shop.model.ShopData;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  17:05
 */
public interface DictMapper {

    public List<BaseDict> findDictByCode(String code);

    public void addBaseDict(ShopData shopData);

    public Integer findLastInsertId();

}

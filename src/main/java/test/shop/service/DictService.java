package test.shop.service;

import test.shop.model.BaseDict;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  17:09
 */
public interface DictService {

    public List<BaseDict> findDictByCode(String code);
}

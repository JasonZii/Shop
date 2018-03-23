package test.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.shop.dao.DictMapper;
import test.shop.model.BaseDict;
import test.shop.service.DictService;

import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  17:10
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<BaseDict> findDictByCode(String code) {

        List<BaseDict> list = dictMapper.findDictByCode(code);

        return list;
    }
}

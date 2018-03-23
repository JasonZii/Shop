package test.shop.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.shop.dao.DictMapper;
import test.shop.dao.ShopperMapper;
import test.shop.model.QueryVo;
import test.shop.model.ShopData;
import test.shop.model.Shopper;
import test.shop.service.ShopperService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  18:40
 */
@Service
@Transactional
public class ShopperServiceImpl implements ShopperService {

    @Autowired
    private ShopperMapper shopperMapper;

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private HttpServletRequest request;

    @Value("${curbName}")
    private String curbName;

    @Value("${curbType}")
    private String curbType;

    @Override
    public List<Shopper> findShopperByVo(QueryVo vo) {

        HttpSession session = request.getSession();
        Object o = session.getAttribute(curbName);
        if(o.equals(curbName)){
            if(vo.getShopType() == null){
                vo.setShopType(curbType);
                List<Shopper> list = shopperMapper.curbFindShopperByVo(vo);
                return list;
            }
            if(vo.getShopType().equals(curbType)){

                vo.setShopType("0");
            }
        }

        List<Shopper> list = shopperMapper.findShopperByVo(vo);

        return list;
    }

    @Override
    public Integer findShopperByVoCount(QueryVo vo) {

        HttpSession session = request.getSession();
        Object o = session.getAttribute(curbName);
        if(o.equals(curbName)){
            if(vo.getShopType() == null){
                Integer count = shopperMapper.curbFindShopperByVoCount(vo);
                return count;
            }
            if(vo.getShopType().equals(curbType)){

                vo.setShopType("0");
            }
        }

        Integer count = shopperMapper.findShopperByVoCount(vo);

        return count;
    }

    @Override
    public Shopper findShopperById(Long id) {

        Shopper shopper = shopperMapper.findShopperById(id);

        return shopper;
    }

    @Override
    public ShopData findShopDataById(Long id) {
        ShopData shopData = shopperMapper.findShopDataById(id);

        return shopData;
    }

    @Override
    public void updateShopDataById(ShopData shopData) {

        shopperMapper.updateShopDataById(shopData);

    }

    @Override
    public void deleteShopDataById(Long id) {

        shopperMapper.deleteShopDataById(id);
    }

    @Override
    @Transactional
    public void addShop(ShopData shopData) {

        dictMapper.addBaseDict(shopData);
        Integer id = dictMapper.findLastInsertId();
        System.out.println(id);
        shopData.setShop_matter(id.toString());
        shopperMapper.addShopper(shopData);

    }

    @Override
    public Integer findAllCount() {

        HttpSession session = request.getSession();
        Object o = session.getAttribute(curbName);
        if(o.equals(curbName)){
            Integer allCount = shopperMapper.curbFindAllCount(curbType);
            return allCount;
        }

        Integer allCount = shopperMapper.findAllCount();
        return allCount;
    }


}

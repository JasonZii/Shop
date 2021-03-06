package test.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import test.shop.http.bootstrap.ChatServer;
import test.shop.model.*;
import test.shop.service.DictService;
import test.shop.service.SearchService;
import test.shop.service.ShopperService;

import java.util.List;
import java.util.Map;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.15  12:37
 */
@Controller
@RequestMapping("/shop")
public class UserController {

    @Autowired
    private DictService dictService;

    @Autowired
    private ShopperService shopperService;

    @Value("${shop_dict_type}")
    private String shop_dict_type;

    @Value("${shop_dict_sell}")
    private String shop_dict_sell;

    @Value("${curbName}")
    private String curbName;

    @Autowired
    private ChatServer chatServer;


    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/list")
    public String list(QueryVo vo,@RequestParam(defaultValue = "") String keyword,Model model) throws Exception{

        //商品类别
        List<BaseDict> typeList = dictService.findDictByCode(shop_dict_type);
        //购买方式
        List<BaseDict> sellList = dictService.findDictByCode(shop_dict_sell);
        //数据总数
        Integer allCount = shopperService.findAllCount();

        //把数据库数据存入solr文档域
        boolean b = searchService.importAllShops();

        //字典表显示
        model.addAttribute("typeList",typeList);
        model.addAttribute("sellList",sellList);


        if(vo.getShopName() != null){
            vo.setShopName(new String(vo.getShopName().getBytes("iso8859-1"),"utf-8"));
        }

        if(vo.getPage() == null){
            vo.setPage(1);
        }

        //设置 每一页从第几条开始查
        vo.setStart((vo.getPage() - 1) * vo.getSize());

        //数据和数据总数
        List<Shopper> list = shopperService.findShopperByVo(vo);
        Integer count = shopperService.findShopperByVoCount(vo);

        Page<Shopper> page = new Page<Shopper>();

//        if(keyword != null && keyword != "") {
        if(!("".equals(keyword))) {
            keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
             page = searchService.searchPage(keyword, vo.getPage(), vo.getSize());

            page.setSize(vo.getSize());
            page.setPage(vo.getPage());
        }

        else {
//            Page<Shopper> page = new Page<Shopper>();
            page.setTotal(count);
            page.setSize(vo.getSize());
            page.setPage(vo.getPage());
            page.setRows(list);   //数据

            if ((allCount) % vo.getSize() == 0) {
                page.setPageCount((allCount) / vo.getSize());
            } else {
                page.setPageCount((allCount) / vo.getSize() + 1);
            }
        }

        model.addAttribute("page",page);

        model.addAttribute("shopName",vo.getShopName());
        model.addAttribute("shopSource",vo.getShopSource());
        model.addAttribute("shopType",vo.getShopType());


        return "shop";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Shopper edit(Long id)throws Exception{

        Shopper shopper = shopperService.findShopperById(id);

        return shopper;

    }

    @RequestMapping("/edit2")
    @ResponseBody
    public ShopData edit2(Long id)throws Exception{
        ShopData shopData = shopperService.findShopDataById(id);

        return shopData;

    }

    @RequestMapping("/update")
    public String update(ShopData shopData)throws Exception{

        shopperService.updateShopDataById(shopData);

        return "shop";
    }

    @RequestMapping("/delete")
    public String delete(Long id)throws Exception{

        shopperService.deleteShopDataById(id);

        return "shop";
    }

    @RequestMapping("/add")
    public String add(ShopData shopData)throws Exception{

        shopperService.addShop(shopData);

        return "shop";
    }

    @RequestMapping("/buyTable")
    @ResponseBody
    public Table buyTable(@RequestParam String beginDate,
                           @RequestParam String endDate
                           )throws Exception{

        Map<String,Integer> map = shopperService.findTypeSumMoney(beginDate, endDate);

        /* keySet
        for(String key:map.keySet()){
            Integer value = map.get(key);
        }*/

        Table t = new Table();

        //entrySet
        for (Map.Entry<String,Integer> vo:map.entrySet()) {

            if(vo.getKey().equals("1"))
            {
               t.setCommodity(vo.getValue());
            }else if(vo.getKey().equals("2"))
            {
                t.setElectron(vo.getValue());

            }else if(vo.getKey().equals("3"))
            {
                t.setFood(vo.getValue());

            }else if(vo.getKey().equals("4"))
            {
                t.setClothes(vo.getValue());

            }else if(vo.getKey().equals("allSumMoneyByDate"))
            {
                t.setTotalSpend(vo.getValue());
            }
        }


        return t;

    }


    @RequestMapping("/test")
    public String show()throws Exception{
//        int a = 1/0;
        return "exception";
    }

}

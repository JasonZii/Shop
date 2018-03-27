package test.shop.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.shop.dao.SearchDao;
import test.shop.dao.SearchMapper;
import test.shop.model.Page;
import test.shop.model.SearchShop;
import test.shop.model.Shopper;
import test.shop.service.SearchService;

import javax.sql.rowset.serial.SerialArray;
import java.util.List;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.25  22:46
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private SearchDao searchDao;


    @Override
    public boolean importAllShops() {

        try {

            List<SearchShop> shopList = searchMapper.getShopList();

            for (SearchShop searchShop : shopList) {

                SolrInputDocument document = new SolrInputDocument();

                document.addField("id", searchShop.getShop_id());
                document.addField("shop_name", searchShop.getShop_name());
                document.addField("shop_source", searchShop.getShop_source());
                document.addField("shop_type", searchShop.getShop_type());
                document.addField("shop_matter", searchShop.getShop_matter());
                document.addField("shop_price", searchShop.getShop_price());
                document.addField("shop_address", searchShop.getShop_address());
                document.addField("sell_phone", searchShop.getSell_phone());
                document.addField("sell_man", searchShop.getSell_man());
                document.addField("shop_createtime", searchShop.getShop_createtime());

                solrServer.add(document);
            }

            solrServer.commit();

            return true;
        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }

    }

    @Override
    public Page searchPage(String keyword,int page,int rows) throws Exception {

        SolrQuery query = new SolrQuery();

        query.setQuery(keyword);

        if(page <= 0) page=1;
        query.setStart((page-1)*rows);
        query.setRows(rows);

        query.set("df","shop_matter");

        query.setHighlight(true);
        query.addHighlightField("shop_matter");
        query.setHighlightSimplePre("<em style=\"color:red\">");
        query.setHighlightSimplePost("</em>");

        Page p = searchDao.search(query);

        int recordCount = p.getTotal();
        int pageCount = (recordCount/rows);
        if(recordCount % rows > 0)
            pageCount ++;

        p.setPageCount(pageCount);

        return p;
    }
}

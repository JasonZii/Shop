package test.shop.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import test.shop.model.Page;
import test.shop.model.SearchShop;
import test.shop.model.Shopper;

import javax.naming.directory.SearchResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.26  15:14
 */
@Repository
public class SearchDao {

    @Autowired
    private SolrServer solrServer;

    /**
     * 根据查询条件查询索引库
     * @param query
     * @return
     */

    public Page search(SolrQuery query) throws Exception{
        //根据query查询索引库
        QueryResponse queryResponse = solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        //取结果的总记录数
        int numFound = (int) solrDocumentList.getNumFound();

        Page p = new Page();

        p.setTotal(numFound);

        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        List<Shopper> shopList = new ArrayList<>();
        for (SolrDocument solrDocument:solrDocumentList) {
            Shopper shop = new Shopper();
            shop.setShop_id(Long.parseLong((String) solrDocument.get("id")));
            shop.setShop_name((String) solrDocument.get("shop_name"));
            shop.setShop_source((String) solrDocument.get("shop_source"));
            shop.setShop_type((String) solrDocument.get("shop_type"));
            shop.setShop_matter((String) solrDocument.get("shop_matter"));
            shop.setShop_price((String) solrDocument.get("shop_price"));
            shop.setShop_address((String) solrDocument.get("shop_address"));
            shop.setSell_phone((String) solrDocument.get("sell_phone"));
            shop.setSell_man((String) solrDocument.get("sell_man"));

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            String sdate=(String)solrDocument.get("shop_createtime");
            Date ddate;
            ddate=sdf.parse(sdate);
            shop.setShop_createtime(ddate);

            List<String> l = highlighting.get(solrDocument.get("id")).get("shop_matter");

            String matter = "";
            if(l != null && l.size() > 0){
                matter = l.get(0);
            }else {
                matter = (String)solrDocument.get("shop_matter");
            }

            shop.setShop_matter(matter);

            shopList.add(shop);
        }

        p.setRows(shopList);

        return p;

    }


}

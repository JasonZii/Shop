package test.shop.message;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import sun.org.mozilla.javascript.internal.EcmaError;
import test.shop.dao.ShopperMapper;
import test.shop.model.Shopper;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.27  18:56
 */
public class ShopAddMessageListener implements MessageListener{

    @Autowired
    private ShopperMapper shopperMapper;

    @Autowired
    private SolrServer solrServer;

    @Override
    public void onMessage(Message message) {

        try {

            TextMessage textMessage = (TextMessage) message;

            String text = textMessage.getText();

            Long id = new Long(text);

            Thread.sleep(100);

            Shopper shopper = shopperMapper.findShopperById(id);

            SolrInputDocument document = new SolrInputDocument();

            document.addField("id", (shopper.getShop_id()).toString());
            document.addField("shop_name", shopper.getShop_name());
            document.addField("shop_source", shopper.getShop_source());
            document.addField("shop_type", shopper.getShop_type());
            document.addField("shop_matter", shopper.getShop_matter());
            document.addField("shop_price", shopper.getShop_price());
            document.addField("shop_address", shopper.getShop_address());
            document.addField("sell_phone", shopper.getSell_phone());
            document.addField("sell_man", shopper.getSell_man());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.format(shopper.getShop_createtime());
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            document.addField("shop_createtime", sdf);

            solrServer.add(document);


            solrServer.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

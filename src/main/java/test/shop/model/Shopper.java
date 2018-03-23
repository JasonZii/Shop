package test.shop.model;

import com.sun.org.apache.xml.internal.serializer.SerializerTrace;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.15  17:58
 */
public class Shopper implements Serializable {

    private Long shop_id;
    private String shop_name;
    private String shop_source;
    private String shop_type;
    private String shop_matter;
    private String shop_price;

    private String sell_man;

    private String sell_phone;
    private String shop_address;
    private Date shop_createtime;




    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_source() {
        return shop_source;
    }

    public void setShop_source(String shop_source) {
        this.shop_source = shop_source;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getShop_matter() {
        return shop_matter;
    }

    public void setShop_matter(String shop_matter) {
        this.shop_matter = shop_matter;
    }

    public String getSell_man() {
        return sell_man;
    }

    public void setSell_man(String sell_man) {
        this.sell_man = sell_man;
    }

    public String getSell_phone() {
        return sell_phone;
    }

    public void setSell_phone(String sell_phone) {
        this.sell_phone = sell_phone;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public Date getShop_createtime() {
        return shop_createtime;
    }

    public void setShop_createtime(Date shop_createtime) {
        this.shop_createtime = shop_createtime;
    }
}

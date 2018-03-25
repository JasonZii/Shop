package test.shop.model;

import java.io.Serializable;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.25  22:35
 */
public class SearchShop implements Serializable {

    /*	a.shop_id,
	a.shop_name,
	d.dict_item_name shop_source,
	b.dict_item_name shop_type,
	c.dict_item_name shop_matter,
	a.shop_price,
	a.shop_address,
	a.sell_phone,
	a.sell_man,
	a.shop_createtime
	*/

    private String shop_id;
    private String shop_name;
    private String shop_source;
    private String shop_type;
    private String shop_matter;
    private String shop_price;
    private String shop_address;
    private String sell_phone;
    private String sell_man;
    private String shop_createtime;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
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

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getSell_phone() {
        return sell_phone;
    }

    public void setSell_phone(String sell_phone) {
        this.sell_phone = sell_phone;
    }

    public String getSell_man() {
        return sell_man;
    }

    public void setSell_man(String sell_man) {
        this.sell_man = sell_man;
    }

    public String getShop_createtime() {
        return shop_createtime;
    }

    public void setShop_createtime(String shop_createtime) {
        this.shop_createtime = shop_createtime;
    }
}

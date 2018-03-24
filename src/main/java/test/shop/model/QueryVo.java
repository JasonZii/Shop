package test.shop.model;

public class QueryVo {

	private String shopName;
	private String shopSource;
	private String shopType;
	private Integer page = 1;
	private Integer start;
	private Integer size = 10;




	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopSource() {
		return shopSource;
	}

	public void setShopSource(String shopSource) {
		this.shopSource = shopSource;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}

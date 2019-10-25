package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
/**
 * 商品类
 * @author wang
 *
 */
public class Commodity {

	private String name;
	
	private ItemType isImport;
	
	private ItemOrigin isDutyFree;
	
	private BigDecimal price;
	
	private String dis;
	
	private String aaa;

	private String bbb;
	
	private String ccc;
	
	
	
	public String getDis() {
		return dis;
	}

	public String getAaa() {
		return aaa;
	}

	public String getBbb() {
		return bbb;
	}

	public String getCcc() {
		return ccc;
	}

	public void setDis(String dis) {
		this.dis = dis;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public ItemType getIsImport() {
		return isImport;
	}

	public void setIsImport(ItemType isImport) {
		this.isImport = isImport;
	}

	public ItemOrigin getIsDutyFree() {
		return isDutyFree;
	}

	public void setIsDutyFree(ItemOrigin isDutyFree) {
		this.isDutyFree = isDutyFree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isDutyFree == null) ? 0 : isDutyFree.hashCode());
		result = prime * result + ((isImport == null) ? 0 : isImport.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (isDutyFree != other.isDutyFree)
			return false;
		if (isImport != other.isImport)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	
	
	
	
}

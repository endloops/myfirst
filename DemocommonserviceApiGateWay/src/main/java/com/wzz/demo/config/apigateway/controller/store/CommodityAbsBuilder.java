package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
/**
 * 商品建造者
 * @author wang
 *
 */
public class CommodityAbsBuilder extends AbsBuilder<Commodity>{

	private Commodity commodity = new Commodity();
	
	@Override
	public Commodity build() {
		// TODO Auto-generated method stub
		return commodity;
	}
	
	CommodityAbsBuilder setIsImport(ItemType isImport) {
		commodity.setIsImport(isImport);
		return this;
	}

	public CommodityAbsBuilder setIsDutyFree(ItemOrigin isDutyFree) {
		commodity.setIsDutyFree(isDutyFree);
		return this;
	}

	public CommodityAbsBuilder setName(String name) {
		commodity.setName(name);
		return this;
	}
	
	public CommodityAbsBuilder setPrice(BigDecimal price) {
		commodity.setPrice(price);
		return this;
	}

	public CommodityAbsBuilder setDis(String dis) {
		commodity.setDis(dis);
		return this;
	}

	public CommodityAbsBuilder setAaa(String aaa) {
		commodity.setAaa(aaa);
		return this;
	}

	public CommodityAbsBuilder setBbb(String bbb) {
		commodity.setBbb(bbb);
		return this;
	}

	public CommodityAbsBuilder setCcc(String ccc) {
		commodity.setCcc(ccc);
		return this;
	}
}

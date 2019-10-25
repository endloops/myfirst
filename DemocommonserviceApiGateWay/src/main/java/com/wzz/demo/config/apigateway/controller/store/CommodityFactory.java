package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
/**
 * 商品工厂
 * @author wang
 *
 */
public class CommodityFactory {

	public static Commodity create(String[] source) {
		CommodityAbsBuilder absBuilder = new CommodityAbsBuilder();
		Commodity commodity = absBuilder.setName(source[0])
		.setIsImport(ItemType.valueOf(source[1]))
		.setIsDutyFree(ItemOrigin.valueOf(source[2]))
		.setPrice(new BigDecimal(source[3])).build();
		return commodity;

	}

}
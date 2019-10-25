package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 中国某一种税务模式
 * @author wang
 *
 */
public class ChinaSheRuShuiWuSuanFaTemplate extends SheRuShuiWuSuanFaTemplate {

	@Override
	public BigDecimal bigDecimal(BigDecimal tax) {
		
		return  tax.setScale(1, RoundingMode.UP);
	}

	@Override
	public BigDecimal smallDecimal(BigDecimal tax) {

		return tax.setScale(1, RoundingMode.DOWN);
	}

}

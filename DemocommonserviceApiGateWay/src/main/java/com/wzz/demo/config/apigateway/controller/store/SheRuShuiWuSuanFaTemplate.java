package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;

/**
 * 一种税务模板
 * @author wang
 *
 */
public abstract class SheRuShuiWuSuanFaTemplate implements ShuiWuSuanFa {

	@Override
	public BigDecimal getShuiRu(BigDecimal tax) {
		if (tax != null) {
			tax = tax.setScale(2,BigDecimal.ROUND_HALF_UP);
			BigDecimal big = bigDecimal(tax);
			BigDecimal small = smallDecimal(tax);
			BigDecimal avge = big.add(small).divide(new BigDecimal("2"));
			if (tax.compareTo(avge) > 0) {
				return big;
			} else {
				return avge;
			}
		}else{
			return new BigDecimal("0");
		}

	}

	public abstract BigDecimal bigDecimal(BigDecimal tax);

	public abstract BigDecimal smallDecimal(BigDecimal tax);

}

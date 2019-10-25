package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;

/**
 * 税务局
 * @author wang
 *
 */
public abstract class TaxDepartment {
	/**
	 * 商品
	 */
	private Commodity source;
	/**
	 * 税务结果集算法
	 */
	private ShuiWuSuanFa shuiWuSuanFa;

	public ShuiWuSuanFa getShuiWuSuanFa() {
		return shuiWuSuanFa;
	}

	public void setShuiWuSuanFa(ShuiWuSuanFa shuiWuSuanFa) {
		this.shuiWuSuanFa = shuiWuSuanFa;
	}

	public Commodity getSource() {
		return source;
	}

	public void setSource(Commodity source) {
		this.source = source;
	}

	public BigDecimal getTax() {

		BigDecimal taxPercentage = getTaxPercentage();

		BigDecimal price = getPrice();

		BigDecimal tax = price.multiply(taxPercentage);

		return getShuiRu(tax);

	}

	public BigDecimal getPrice() {
		if (source != null) {
			return source.getPrice();
		} else {
			return new BigDecimal("0");
		}
	}

	public abstract BigDecimal getTaxPercentage();

	public BigDecimal getShuiRu(BigDecimal tax) {
		if (shuiWuSuanFa == null) {
			return tax;
		}
		return shuiWuSuanFa.getShuiRu(tax);
	};

}

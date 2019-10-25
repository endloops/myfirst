package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 （订单中心）
 * @author wang
 *
 */
public class PaymentCenter implements Observer{
	
	private BigDecimal price;
	
	private BigDecimal tax;
	
	@Override
	public void update(Observable o, Object arg) {
		interfaceClass();
		TaxDepartment shopTemplate = new ChinaTaxDepartment();
		shopTemplate.setShuiWuSuanFa(new ChinaSheRuShuiWuSuanFaTemplate());
		Map<Commodity, Integer> map = (Map<Commodity, Integer>) arg;
		for (Map.Entry<Commodity, Integer> m :map.entrySet()) {
			shopTemplate.setSource(m.getKey());
			BigDecimal tax = shopTemplate.getTax();
			this.tax = this.tax.add(tax.multiply(new BigDecimal(m.getValue())));
			System.out.println("tax:" + tax.doubleValue());
			BigDecimal price = tax.add(shopTemplate.getSource().getPrice());
			System.out.println("price:" + price.setScale(2).toString());
			this.price = this.price.add(price.multiply(new BigDecimal(m.getValue())));
		}
	}
	
	public void interfaceClass() {
		this.price = new BigDecimal("0");
		this.tax = new BigDecimal("0");
	}

	public BigDecimal getPrice() {
		return price;
	}
	public BigDecimal getTax() {
		return tax;
	}
}

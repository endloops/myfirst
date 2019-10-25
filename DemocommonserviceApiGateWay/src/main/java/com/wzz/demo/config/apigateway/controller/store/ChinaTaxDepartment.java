package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
/**
 * 中国税务局
 * @author wang
 *
 */
public class ChinaTaxDepartment extends TaxDepartment{
	/**
	 * 指定哪些type 免税
	 */
	private ItemType[] itemsFree = {ItemType.foods,ItemType.medicine,ItemType.books};
	/**
	 * 指定进口税
	 */
	private BigDecimal importPercentage = new BigDecimal("0.05");
	/**
	 * 指定统一征税
	 */
	private BigDecimal dutyFreePercentage = new BigDecimal("0.10");  
	/**
	 * 初始化税务结果
	 */
	private BigDecimal taxPercentage = new BigDecimal("0");
	/**
	 * 是否进口
	 */
	public void isImport() {
		if(super.getSource().getIsDutyFree().compareTo(ItemOrigin.imported)==0){
			taxPercentage = taxPercentage.add(importPercentage);
		}
	
	}
	/**
	 * 是否免税
	 */
	public void isDutyFree() {
		ItemType superItem = super.getSource().getIsImport(); 
		boolean status = false;
		for (int i = 0; i < itemsFree.length; i++) {
			if(itemsFree[i].compareTo(superItem)==0){
				status = true;
			}
		}
		if(!status){
			taxPercentage = taxPercentage.add(dutyFreePercentage);
		}
		
	}
	/**
	 * 初始化税务率
	 */
	private void instanceTaxPercentage(){
		taxPercentage = new BigDecimal("0");
	}
	/**
	 * 获得税务率
	 */
	@Override
	public BigDecimal getTaxPercentage() {
		instanceTaxPercentage();
		isImport();
		isDutyFree();
		return taxPercentage;
	}
	
}

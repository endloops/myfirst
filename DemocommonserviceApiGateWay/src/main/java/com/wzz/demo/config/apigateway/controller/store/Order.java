package com.wzz.demo.config.apigateway.controller.store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;


/**
 * 被观察者（订单）
 * @author wang
 *
 */
public class Order extends Observable{
	
	private Map<Commodity, Integer> commodities = Collections.synchronizedMap(new HashMap<Commodity, Integer>());
	
	public void addNewCommodity(Commodity commodity,int number){
		
		commodities.put(commodity, number);
	}
	public void removeCommodity(Commodity commodity,int x){
		
		commodities.remove(commodity);
	}
	public void instanceCommodity(){
		commodities = Collections.synchronizedMap(new HashMap<Commodity, Integer>());
	}
	public void sendOrder(){
		setChanged();
		notifyObservers(this.commodities);
	}
}

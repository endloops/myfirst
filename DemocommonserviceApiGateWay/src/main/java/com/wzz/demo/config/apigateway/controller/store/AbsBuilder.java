package com.wzz.demo.config.apigateway.controller.store;

public abstract class AbsBuilder<T> {
	/**
     * 建造者建造后要返回的对象
     * */
    abstract T build();

}

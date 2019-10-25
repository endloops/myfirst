package com.wzz.demo.config.apigateway.controller.store;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * 税务接口
 * @author wang
 *
 */
public interface ShuiWuSuanFa {
	
	BigDecimal getShuiRu(BigDecimal tax);
}

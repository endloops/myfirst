package com.wzz.demo.integration.service.service.interfaces;

import com.wzz.demo.integration.service.repository.RedisDao;
import com.wzz.demo.integration.service.service.request.UserInformationRibbonModel;
/**
 * 查询用户信息接口
 * @author wang
 *
 */
public interface UserInformationService {
	/**
	 * 根据ID查询用户信息详情
	 * @param id
	 * 		id: 用户在数据库表的ID
	 * @return
	 * 		UserInformationRibbonModel： 用户信息详情
	 * @throws Exception 
	 */
	public UserInformationRibbonModel searchUserByID(Long id) throws Exception;
		
	public <T> T getOneInformation(Object key,Class<T> T);

	<T> T saveNewInformation(Object key, Object value, Class<T> valueClass);

	<T> T saveNewInformation(String key, Object value, Class<T> valueClass);

	<T> T getOneInformation(String key, Class<T> T);
	
}

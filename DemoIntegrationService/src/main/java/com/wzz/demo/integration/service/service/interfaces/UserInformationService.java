package com.wzz.demo.integration.service.service.interfaces;

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
	 */
	public UserInformationRibbonModel searchUserByID(Long id);
}

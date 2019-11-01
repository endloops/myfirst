package com.wzz.demo.integration.service.common.header;

/**
 * 
 * @author zhangshihao
 *
 */
public class ClientInformation {

	/**
	 * 职员编号.
	 */
	private String agentCode;

	private String machineid;

	public String getMachineid() {
		return machineid;
	}

	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

}

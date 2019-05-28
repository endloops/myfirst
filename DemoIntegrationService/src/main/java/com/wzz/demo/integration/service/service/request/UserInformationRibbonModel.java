package com.wzz.demo.integration.service.service.request;

public class UserInformationRibbonModel {
	
	private String userName;
	
	private String passWord;
	
	private String nickName;

	private String exceptionCode;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	public UserInformationRibbonModel(String userName, String passWord, String nickName, String exceptionCode) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
		this.exceptionCode = exceptionCode;
	}

	public UserInformationRibbonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInformationRibbonModel(String exceptionCode) {
		super();
		this.exceptionCode = exceptionCode;
	}

	@Override
	public String toString() {
		return "UserInformationRibbonModel [userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName
				+ ", exceptionCode=" + exceptionCode + "]";
	}
	
	
	
}

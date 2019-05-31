package com.wzz.demo.db.controller.response;

public class UserInformationRibbonModel {
	
	private String userName;
	
	private String passWord;
	
	private String nickName;
	
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
	
	public UserInformationRibbonModel(String userName, String passWord, String nickName, String exceptionCode) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
	}

	public UserInformationRibbonModel() {
		super();
		// TODO Auto-generated constructor stub
	}	
}

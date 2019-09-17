package com.wzz.demo.integration.service.service.request;
/**
 * 用户信息查询的结果.
 * 加入Exception,描述有无失败的异常描述信息.
 * @author wang
 *
 */
public class UserInformationRibbonModel {
	
	private String userName;
	
	private String passWord;
	
	private String nickName;

	private String exceptionCode;
	
	private String errException;
	
	private String errorMessage;
	
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

	public UserInformationRibbonModel(String exceptionCode,String errMessage,String exceptionClass) {
		super();
		this.exceptionCode = exceptionCode;
		this.errorMessage = errMessage;
		this.errException = exceptionClass;
	}

	public String getErrException() {
		return errException;
	}

	public void setErrException(String errException) {
		this.errException = errException;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "UserInformationRibbonModel [userName=" + userName + ", passWord=" + passWord + ", nickName=" + nickName
				+ ", exceptionCode=" + exceptionCode + ", errException=" + errException + ", errorMessage="
				+ errorMessage + "]";
	}

	
	
	
}

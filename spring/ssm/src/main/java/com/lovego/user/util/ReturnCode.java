package com.lovego.user.util;

public enum ReturnCode{ 
	C200(200, "操作成功"), 
	C500(500, "服务器错误");
	
	private final int status;
	private final String message;

	ReturnCode(int status, String message){
		this.status = status;
		this.message = message;
	}

	public int getStatus(){
		return status;
	}

	public String getMessage(){
		return message;
	}
}
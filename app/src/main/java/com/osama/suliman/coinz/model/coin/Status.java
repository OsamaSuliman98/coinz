package com.osama.suliman.coinz.model.coin;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("code")
	private int code;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public int getCode(){
		return code;
	}

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}
}
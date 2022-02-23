package com.osama.suliman.coinz.model.coin;

import com.google.gson.annotations.SerializedName;

public class CurrenciesItem{

	@SerializedName("b_enabled")
	private boolean bEnabled;

	@SerializedName("dt_created_date")
	private String dtCreatedDate;

	@SerializedName("dt_modified_date")
	private String dtModifiedDate;

	@SerializedName("pk_i_id")
	private int pkIId;

	@SerializedName("dt_deleted_date")
	private Object dtDeletedDate;

	@SerializedName("d_trading")
	private String dTrading;

	@SerializedName("s_name")
	private String sName;

	@SerializedName("s_icon")
	private String sIcon;

	@SerializedName("d_value")
	private String dValue;

	@SerializedName("s_code")
	private String sCode;

	public boolean isBEnabled(){
		return bEnabled;
	}

	public String getDtCreatedDate(){
		return dtCreatedDate;
	}

	public String getDtModifiedDate(){
		return dtModifiedDate;
	}

	public int getPkIId(){
		return pkIId;
	}

	public Object getDtDeletedDate(){
		return dtDeletedDate;
	}

	public String getDTrading(){
		return dTrading;
	}

	public String getSName(){
		return sName;
	}

	public String getSIcon(){return sIcon;}

	public String getDValue(){
		return dValue;
	}

	public String getSCode(){
		return sCode;
	}

	public void setbEnabled(boolean bEnabled) {
		this.bEnabled = bEnabled;
	}

	public void setPkIId(int pkIId) {
		this.pkIId = pkIId;
	}

	public void setdTrading(String dTrading) {
		this.dTrading = dTrading;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setsIcon(String sIcon) {
		this.sIcon = sIcon;
	}


}
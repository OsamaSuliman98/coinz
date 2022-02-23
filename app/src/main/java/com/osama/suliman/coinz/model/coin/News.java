package com.osama.suliman.coinz.model.coin;

import com.google.gson.annotations.SerializedName;

public class News{

	@SerializedName("s_title")
	private String sTitle;

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

	@SerializedName("s_image")
	private String sImage;

	@SerializedName("s_description")
	private String sDescription;

	public String getSTitle(){
		return sTitle;
	}

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

	public String getSImage(){
		return sImage;
	}

	public String getSDescription(){
		return sDescription;
	}
}
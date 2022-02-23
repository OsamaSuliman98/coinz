package com.osama.suliman.coinz.model.coin;

import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("i_items_on_page")
	private int iItemsOnPage;

	@SerializedName("i_current_page")
	private int iCurrentPage;

	@SerializedName("i_total_objects")
	private int iTotalObjects;

	@SerializedName("i_per_pages")
	private int iPerPages;

	@SerializedName("i_total_pages")
	private int iTotalPages;

	public int getIItemsOnPage(){
		return iItemsOnPage;
	}

	public int getICurrentPage(){
		return iCurrentPage;
	}

	public int getITotalObjects(){
		return iTotalObjects;
	}

	public int getIPerPages(){
		return iPerPages;
	}

	public int getITotalPages(){
		return iTotalPages;
	}
}
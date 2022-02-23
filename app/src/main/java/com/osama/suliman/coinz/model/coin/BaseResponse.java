package com.osama.suliman.coinz.model.coin;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseResponse{

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("condition")
	private List<Condition> condition = new ArrayList<>();

	public List<Condition> getCondition() {
		return condition;
	}

	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}

	@SerializedName("status")
	private Status status;

	@SerializedName("currencies")
	private List<CurrenciesItem> currencies;

	@SerializedName("news")
	private List<News> newsList;

	public Pagination getPagination(){
		return pagination;
	}

	public Status getStatus(){
		return status;
	}

	public List<CurrenciesItem> getCurrencies(){
		return currencies;
	}

	public List<News> getNewsList() {
		return newsList;
	}
}
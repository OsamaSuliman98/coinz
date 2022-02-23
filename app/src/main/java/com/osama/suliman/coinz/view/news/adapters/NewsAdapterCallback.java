package com.osama.suliman.coinz.view.news.adapters;

import com.osama.suliman.coinz.model.coin.News;
import com.osama.suliman.coinz.model.news.LocalNews;

public interface NewsAdapterCallback {
    void onClickItem(int position , News news);
}

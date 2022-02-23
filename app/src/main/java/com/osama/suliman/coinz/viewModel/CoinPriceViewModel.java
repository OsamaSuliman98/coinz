package com.osama.suliman.coinz.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CoinPriceViewModel extends ViewModel {

    public MutableLiveData<String> mText = new MutableLiveData<>();

    public CoinPriceViewModel() {
        mText.setValue("Osama");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
package com.osama.suliman.coinz.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditViewModel {
    public MutableLiveData<String> mText = new MutableLiveData<>();

    public EditViewModel() {
        mText.setValue("Osama");

    }

    public LiveData<String> getText() {
        return mText;
    }
}


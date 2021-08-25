package com.example.dove.ble;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BleViewModel extends ViewModel {
    private MutableLiveData<String> mText1, mText2;

    public BleViewModel() {
        mText1 = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
    }
}

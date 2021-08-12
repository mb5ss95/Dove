package com.example.dove.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> mText1, mText2;

    public MainViewModel() {
        mText1 = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
    }

    public void setText1(String s){
        mText1.setValue(s);
    }

    public void setText2(String s){
        mText2.setValue(s);
    }

    public LiveData<String> getText1() {
        return mText1;
    }

    public LiveData<String> getText2() {
        return mText2;
    }

}

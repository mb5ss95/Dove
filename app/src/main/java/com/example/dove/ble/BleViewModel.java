package com.example.dove.ble;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dove.ItemRepository;
import com.example.dove.ListItemModel;

import java.util.ArrayList;

public class BleViewModel extends AndroidViewModel {
    private final ItemRepository itemRepository;

    public BleViewModel(Application application) {
        super(application);
        itemRepository = new ItemRepository();
    }

    public MutableLiveData<ArrayList<ListItemModel>> getMutableLiveDataItemsList(){
        return itemRepository.getMutableLiveDataItemList();
    }

    public void loadItems(){
        itemRepository.loadItems();
    }

    public boolean IsReadyToStart(){
        return itemRepository.isReadyToStart();
    }
}

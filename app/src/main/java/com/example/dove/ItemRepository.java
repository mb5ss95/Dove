package com.example.dove;

import android.os.Looper;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class ItemRepository implements ListItemModel.OnStatusChangeListener{
    private final ArrayList<ListItemModel> items = new ArrayList<>();
    private final MutableLiveData<ArrayList<ListItemModel>> mutableLiveDataItemList = new MutableLiveData<>();

    public ItemRepository(){
        items.clear();
        items.add(new ListItemModel(this, "item1", "READY", 2));
        items.add(new ListItemModel(this, "item2", "READY", 5));
        items.add(new ListItemModel(this, "item3", "READY", 8));
        notifyItemsChanged();
    }

    @Override
    public void OnStatusChanged(ListItemModel listItemModel, String status) {
        notifyItemsChanged();
    }

    public MutableLiveData<ArrayList<ListItemModel>> getMutableLiveDataItemList() {
        return mutableLiveDataItemList;
    }

    public void loadItems(){
        for(ListItemModel item : items){
            item.load();
        }
    }

    public boolean isReadyToStart(){
        for(ListItemModel item : items){
            if("DOING".equals(item.getStatus())){
                return false;
            }
        }
        return true;
    }

    private void notifyItemsChanged(){
        if(Looper.myLooper() == Looper.getMainLooper()){
            mutableLiveDataItemList.setValue(items);
        }
        else{
            mutableLiveDataItemList.postValue(items);
        }
    }
}

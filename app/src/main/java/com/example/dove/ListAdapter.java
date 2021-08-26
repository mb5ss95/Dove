package com.example.dove;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dove.databinding.ListItemBinding;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<ListItemModel> listItemModels;

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item, parent, false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItemModel currentItem = listItemModels.get(position);
        holder.listItemBinding.setItems(currentItem);
    }

    @Override
    public int getItemCount() {
        if(listItemModels != null){
            return listItemModels.size();
        }
        else{
            return 0;
        }
    }

    public void setItemsList(ArrayList<ListItemModel> listItemModels){
        this.listItemModels = listItemModels;
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding listItemBinding;
        public ViewHolder(@NonNull ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;
        }
    }
}
package com.example.dove.ble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dove.ListAdapter;
import com.example.dove.ListItemModel;
import com.example.dove.databinding.FragmentBleBinding;

import java.util.ArrayList;


public class BleFragment extends Fragment {
    private BleViewModel bleViewModel;
    private ListAdapter listAdapter;
    public ObservableBoolean isReadyToStart = new ObservableBoolean();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bleViewModel = new ViewModelProvider(this).get(BleViewModel.class);

        FragmentBleBinding fragmentBleBinding = FragmentBleBinding.inflate(inflater, container, false);
        View root = fragmentBleBinding.getRoot();

        RecyclerView recyclerView = fragmentBleBinding.fragmentBleRecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setHasFixedSize(true);
        listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);

        bleViewModel.getMutableLiveDataItemsList().observe(getViewLifecycleOwner(), (Observer<ArrayList<ListItemModel>>) items -> {
            listAdapter.setItemsList((ArrayList<ListItemModel>) items);
            isReadyToStart.set(bleViewModel.IsReadyToStart());
        });
        return root;
    }

    public void onStartButtonClicked(View view){
        bleViewModel.loadItems();
    }
}

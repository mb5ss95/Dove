package com.example.dove.ble;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dove.databinding.FragmentBleBinding;


public class BleFragment extends Fragment {
    private BleViewModel bleViewModel;
    private FragmentBleBinding fragmentBleBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bleViewModel = new ViewModelProvider(this).get(BleViewModel.class);

        fragmentBleBinding = FragmentBleBinding.inflate(inflater, container, false);
        View root = fragmentBleBinding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView recyclerView = fragmentBleBinding.fragmentBleRecycle;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentBleBinding = null;
    }
}

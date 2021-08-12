package com.example.dove.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dove.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private MainViewModel mainViewModel;
    private FragmentMainBinding fragmentMainBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        View root = fragmentMainBinding.getRoot();



        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //final TextView textView1 = fragmentMainBinding.fragmentMainText1;
        final TextView textView2 = fragmentMainBinding.fragmentMainText2;
        final LinearLayout linearLayout = fragmentMainBinding.fragmentMainLinear;
        final SeekBar seekBar = fragmentMainBinding.fragmentMainSeekBar;

        mainViewModel.getText1().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView1.setText(s);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMainBinding = null;
    }
}

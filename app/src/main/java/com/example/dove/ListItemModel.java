package com.example.dove;


import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class ListItemModel {
    public String title;
    public String status;
    private final OnStatusChangeListener listener;
    private final int fakeLoadingTimeSeconds;

    public interface OnStatusChangeListener{
        void OnStatusChanged(ListItemModel listItemModel, String status);
    }

    public ListItemModel(OnStatusChangeListener listener, String title, String status, int fakeLoadingTimeSeconds) {
        this.listener = listener;
        this.title = title;
        this.status = status;
        this.fakeLoadingTimeSeconds = fakeLoadingTimeSeconds;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
        listener.OnStatusChanged(this, status);
    }

    @BindingAdapter({"statusIcon"})
    public static void loadStatusIcon(ImageView imageView, String status){
        if("DONE".equals(status)){
            imageView.setImageResource(R.drawable.ic_baseline_bluetooth_24);
        }
        else if("DOING".equals(status)){
            imageView.setImageResource(R.drawable.ic_baseline_home_24);
        }
        else{
            imageView.setImageResource(R.drawable.ic_baseline_queue_music_24);
        }
    }

    void load(){
        setStatus("DOING");
        new Thread(() ->{
            try {
                Thread.sleep(fakeLoadingTimeSeconds * 1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }
}

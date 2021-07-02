package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class TestResultSharedViewModel extends ViewModel {
    private MutableLiveData<String> message = new MutableLiveData<>();

    public void setMessage(String selected){
        message.setValue(selected);
    }

    public LiveData<String> getText(){
        return message;
    }
}

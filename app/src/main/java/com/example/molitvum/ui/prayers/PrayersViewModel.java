package com.example.molitvum.ui.prayers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrayersViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public PrayersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("МолитвУМ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
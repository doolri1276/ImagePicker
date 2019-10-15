package com.doolri1276.imagepicker.helper;

import com.doolri1276.imagepicker.listeners.OnLimitReachedListener;

public class ImagePickerActionUtils {

    public static ImagePickerActionUtils INSTANCE;

    public static ImagePickerActionUtils getInstance() {
        if(INSTANCE == null){
            INSTANCE = new ImagePickerActionUtils();
        }

        return INSTANCE;
    }

    public static ImagePickerActionUtils init() {
        INSTANCE = new ImagePickerActionUtils();
        return INSTANCE;
    }


    private OnLimitReachedListener limitReachedListener;

    public OnLimitReachedListener getLimitReachedListener() {
        return limitReachedListener;
    }

    public void setLimitAction(OnLimitReachedListener limitAction) {
        limitReachedListener = limitAction;
    }
}

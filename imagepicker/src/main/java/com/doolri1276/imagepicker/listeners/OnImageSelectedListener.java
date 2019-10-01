package com.doolri1276.imagepicker.listeners;

import com.doolri1276.imagepicker.model.Image;

import java.util.List;

public interface OnImageSelectedListener {
    void onSelectionUpdate(List<Image> selectedImage);
}

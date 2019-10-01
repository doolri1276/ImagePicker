package com.doolri1276.imagepicker.features.camera;

import com.doolri1276.imagepicker.model.Image;

import java.util.List;

public interface OnImageReadyListener {
    void onImageReady(List<Image> image);
}
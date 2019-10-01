package com.doolri1276.imagepicker.features.imageloader;

import android.widget.ImageView;

import java.io.Serializable;

public interface ImageLoader extends Serializable {
    void loadImage(String path, ImageView imageView, ImageType imageType);
}

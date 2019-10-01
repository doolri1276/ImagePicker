package com.doolri1276.imagepicker.features.common;

import com.doolri1276.imagepicker.model.Folder;
import com.doolri1276.imagepicker.model.Image;

import java.util.List;

public interface ImageLoaderListener {
    void onImageLoaded(List<Image> images, List<Folder> folders);
    void onFailed(Throwable throwable);
}

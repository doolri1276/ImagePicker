package com.doolri1276.imagepicker.features;

import android.graphics.Camera;

import com.doolri1276.imagepicker.features.cameraonly.CameraOnlyConfig;
import com.doolri1276.imagepicker.features.imageloader.DefaultImageLoader;

import java.util.ArrayList;

public class ImagePickerConfigFactory {

    public static CameraOnlyConfig createCameraDefault() {
        CameraOnlyConfig config = new CameraOnlyConfig();
        config.setSavePath(ImagePickerSavePath.DEFAULT);
        config.setReturnMode(ReturnMode.ALL);
        return config;
    }

    public static ImagePickerConfig createDefault() {
        ImagePickerConfig config = new ImagePickerConfig();
        config.setMode(IpCons.MODE_MULTIPLE);
        config.setLimit(IpCons.MAX_LIMIT);
        config.setShowCamera(true);
        config.setFolderMode(false);
        config.setSelectedImages(new ArrayList<>());
        config.setSavePath(ImagePickerSavePath.DEFAULT);
        config.setReturnMode(ReturnMode.NONE);
        config.setImageLoader(new DefaultImageLoader());
        return config;
    }
}


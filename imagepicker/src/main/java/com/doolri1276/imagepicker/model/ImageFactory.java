package com.doolri1276.imagepicker.model;

import com.doolri1276.imagepicker.helper.ImagePickerUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageFactory {

    public static List<Image> singleListFromPath(String path) {
        List<Image> images = new ArrayList<>();
        images.add(new Image(0, ImagePickerUtils.getNameFromFilePath(path), path));
        return images;
    }
}

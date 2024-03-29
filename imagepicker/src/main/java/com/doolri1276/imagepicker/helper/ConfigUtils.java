package com.doolri1276.imagepicker.helper;

import android.content.Context;
import android.util.Log;

import com.doolri1276.imagepicker.R;
import com.doolri1276.imagepicker.features.ImagePickerConfig;
import com.doolri1276.imagepicker.features.IpCons;
import com.doolri1276.imagepicker.features.ReturnMode;
import com.doolri1276.imagepicker.features.common.BaseConfig;

import java.io.Serializable;

import javax.sql.CommonDataSource;

public class ConfigUtils {

    public static ImagePickerConfig checkConfig(ImagePickerConfig config) {
        if (config == null) {
            throw new IllegalStateException("ImagePickerConfig cannot be null");
        }
        if (config.getMode() != IpCons.MODE_SINGLE
                && (config.getReturnMode() == ReturnMode.GALLERY_ONLY
                || config.getReturnMode() == ReturnMode.ALL)) {
            throw new IllegalStateException("ReturnMode.GALLERY_ONLY and ReturnMode.ALL is only applicable in Single Mode!");
        }
        if (config.getImageLoader() != null && !(config.getImageLoader() instanceof Serializable)) {
            throw new IllegalStateException("Custom image loader must be a class that implement ImageLoader." +
                    " This limitation due to Serializeable");
        }
        return config;
    }

    public static boolean shouldReturn(BaseConfig config, boolean isCamera) {
        ReturnMode mode = config.getReturnMode();

        Log.d("TAGG", "ConfigUtils, shouldReturn들어왔다 : " + mode.name() + ", isCamera : " + isCamera);

        if (isCamera) {
            return mode == ReturnMode.ALL || mode == ReturnMode.CAMERA_ONLY || mode == ReturnMode.WHEN_CAMERA;
        } else {
            return mode == ReturnMode.ALL || mode == ReturnMode.GALLERY_ONLY;
        }
    }

    public static String getFolderTitle(Context context, ImagePickerConfig config) {
        final String folderTitle = config.getFolderTitle();
        return ImagePickerUtils.isStringEmpty(folderTitle)
                ? context.getString(R.string.ef_title_folder)
                : folderTitle;
    }

    public static String getImageTitle(Context context, ImagePickerConfig config) {
        final String configImageTitle = config.getImageTitle();
        return ImagePickerUtils.isStringEmpty(configImageTitle)
                ? context.getString(R.string.ef_title_select_image)
                : configImageTitle;
    }

    public static String getDoneButtonText(Context context, ImagePickerConfig config) {
        final String doneButtonText = config.getDoneButtonText();
        return ImagePickerUtils.isStringEmpty(doneButtonText)
                ? context.getString(R.string.ef_done)
                : doneButtonText;
    }
}

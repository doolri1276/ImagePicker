package com.doolri1276.imagepicker.features.camera;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Toast;

import com.doolri1276.imagepicker.R;
import com.doolri1276.imagepicker.helper.StringUtils;

public class CameraHelper {
    public static boolean checkCameraAvailability(Context context) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean isAvailable = intent.resolveActivity(context.getPackageManager()) != null;

        if (!isAvailable) {
            Context appContext = context.getApplicationContext();
            Toast.makeText(appContext,
                    StringUtils.getINSTANCE().getErrorNoCamera(appContext), Toast.LENGTH_LONG).show();
        }
        return isAvailable;
    }
}
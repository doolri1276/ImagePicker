package com.doolri1276.imagepicker.helper;

import android.content.Context;

import com.doolri1276.imagepicker.R;

public class StringUtils {

    private static StringUtils INSTANCE;

    private String ok;
    private String done;
    private String camera;

    //private String titleFolder;
    //private String titleSelectImage;
    private String titlePermissionDenied;

    private String selected;
    private String selectedWithLimit;

    private String errorCreateImageFile;
    private String errorNoCamera;
    private String errorNullCursor;

    private String msgEmptyImages;
    private String msgNoWriteExternalPermission;
    private String msgNoCameraPermission;
    private String msgLimitImages;
    private boolean sizeFirst;

    public static StringUtils getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new StringUtils();
        return INSTANCE;
    }

    public String getOk(Context context) {
        if(ok!= null){
            return ok;
        }
        return context.getString(R.string.ef_ok);
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getCamera(Context context) {
        if(camera != null){
            return camera;
        }
        return context.getString(R.string.ef_camera);
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

//    public String getTitleFolder(Context context) {
//        return titleFolder;
//    }
//
//    public void setTitleFolder(String titleFolder) {
//        this.titleFolder = titleFolder;
//    }

//    public String getTitleSelectImage() {
//        return titleSelectImage;
//    }
//
//    public void setTitleSelectImage(String titleSelectImage) {
//        this.titleSelectImage = titleSelectImage;
//    }

    public String getTitlePermissionDenied(Context context) {
        if(titlePermissionDenied != null){
            return titlePermissionDenied;
        }
        return context.getString(R.string.ef_title_permission_denied);
    }

    public void setTitlePermissionDenied(String titlePermissionDenied) {
        this.titlePermissionDenied = titlePermissionDenied;
    }

    public String getSelected(Context context, int imageSize) {
        if(selected != null){
            if(selected.contains("%d")){
                return String.format(selected, imageSize);
            }else{
                return imageSize + selected;
            }
        }
        else
            return String.format(context.getString(R.string.ef_selected), imageSize);
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSelectedWithLimit(Context context, int imageSize, int limit) {
        if(selectedWithLimit != null){
            if(selectedWithLimit.contains("%1$d") && selectedWithLimit.contains("%2$d")){
                return String.format(selectedWithLimit, imageSize, limit);
            }

        }
        return String.format(context.getString(R.string.ef_selected_with_limit), imageSize, limit);
    }

    public void setSelectedWithLimit(String selectedWithLimit) {
        this.selectedWithLimit = selectedWithLimit;
    }

    public String getErrorCreateImageFile(Context context) {
        if (errorCreateImageFile != null)
            return errorCreateImageFile;
        return context.getString(R.string.ef_error_create_image_file);
    }

    public void setErrorCreateImageFile(String errorCreateImageFile) {
        this.errorCreateImageFile = errorCreateImageFile;
    }

    public String getErrorNoCamera(Context context) {
        if(errorNoCamera != null)
            return errorNoCamera;
        else
            return context.getString(R.string.ef_error_no_camera);
    }

    public void setErrorNoCamera(String errorNoCamera) {
        this.errorNoCamera = errorNoCamera;
    }

    public String getErrorNullCursor(Context context) {
        if(errorNullCursor != null)
            return errorNullCursor;
        return context.getString(R.string.ef_error_null_cursor);
    }

    public void setErrorNullCursor(String errorNullCursor) {
        this.errorNullCursor = errorNullCursor;
    }

    public String getMsgEmptyImages(Context context) {
        if(msgEmptyImages != null)
            return msgEmptyImages;
        return context.getString(R.string.ef_msg_empty_images);
    }

    public void setMsgEmptyImages(String msgEmptyImages) {
        this.msgEmptyImages = msgEmptyImages;
    }

    public String getMsgNoWriteExternalPermission(Context context) {
        if(msgNoWriteExternalPermission != null)
            return msgNoWriteExternalPermission;
        return context.getString(R.string.ef_msg_no_write_external_permission);
    }

    public void setMsgNoWriteExternalPermission(String msgNoWriteExternalPermission) {
        this.msgNoWriteExternalPermission = msgNoWriteExternalPermission;
    }

    public String getMsgNoCameraPermission(Context context) {
        if(msgNoCameraPermission != null)
            return msgNoCameraPermission;
        return context.getString(R.string.ef_msg_no_camera_permission);
    }

    public void setMsgNoCameraPermission(String msgNoCameraPermission) {
        this.msgNoCameraPermission = msgNoCameraPermission;
    }

    public String getMsgLimitImages(Context context, int imageSize, int limit) {
        if(msgLimitImages != null){
            if(msgLimitImages.contains("%d")){
                if(sizeFirst)
                    return String.format(msgLimitImages, imageSize);
                else
                    return String.format(msgLimitImages, limit);
            }else if(msgLimitImages.contains("%1$d") && msgLimitImages.contains("%2$d")){
                if(sizeFirst)
                    return String.format(msgLimitImages, imageSize, limit);
                else
                    return String.format(msgLimitImages, limit, imageSize);
            }
        }
        return context.getString(R.string.ef_msg_limit_images);
    }

    public void setMsgLimitImages(String msgLimitImages, boolean sizeFirst) {
        this.msgLimitImages = msgLimitImages;
        this.sizeFirst = sizeFirst;
    }
}

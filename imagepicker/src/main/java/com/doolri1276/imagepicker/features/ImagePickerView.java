package com.doolri1276.imagepicker.features;

import com.doolri1276.imagepicker.features.common.MvpView;
import com.doolri1276.imagepicker.model.Folder;
import com.doolri1276.imagepicker.model.Image;

import java.util.List;

public interface ImagePickerView extends MvpView {
    void showLoading(boolean isLoading);
    void showFetchCompleted(List<Image> images, List<Folder> folders);
    void showError(Throwable throwable);
    void showEmpty();
    void showCapturedImage();
    void finishPickImages(List<Image> images);
}

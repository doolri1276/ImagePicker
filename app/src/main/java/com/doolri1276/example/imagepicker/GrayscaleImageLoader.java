package com.doolri1276.example.imagepicker;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.doolri1276.imagepicker.features.imageloader.ImageLoader;
import com.doolri1276.imagepicker.features.imageloader.ImageType;

public class GrayscaleImageLoader implements ImageLoader {

    private static final RequestOptions REQUEST_OPTIONS = new RequestOptions().transform(new GrayscaleTransformation());

    @Override
    public void loadImage(String path, ImageView imageView, ImageType imageType) {
        Glide.with(imageView)
                .asBitmap()
                .load(path)
                .transition(BitmapTransitionOptions.withCrossFade())
                .apply(REQUEST_OPTIONS)
                .into(imageView);
    }
}
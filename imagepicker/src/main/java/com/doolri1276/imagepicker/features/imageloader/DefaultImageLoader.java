package com.doolri1276.imagepicker.features.imageloader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.doolri1276.imagepicker.R;

public class DefaultImageLoader implements ImageLoader {

    @Override
    public void loadImage(String path, ImageView imageView, ImageType imageType) {
        Glide.with(imageView.getContext())
                .load(path)
                .apply(RequestOptions
                        .placeholderOf(imageType == ImageType.FOLDER
                                ? R.drawable.ef_folder_placeholder
                                : R.drawable.ef_image_placeholder)
                        .error(imageType == ImageType.FOLDER
                                ? R.drawable.ef_folder_placeholder
                                : R.drawable.ef_image_placeholder)
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }
}

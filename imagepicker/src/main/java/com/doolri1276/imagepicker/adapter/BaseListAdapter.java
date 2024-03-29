package com.doolri1276.imagepicker.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.doolri1276.imagepicker.features.imageloader.ImageLoader;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseListAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private final Context context;
    private final LayoutInflater inflater;
    private final ImageLoader imageLoader;

    public BaseListAdapter(Context context, ImageLoader imageLoader) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.imageLoader = imageLoader;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    public Context getContext() {
        return context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }
}

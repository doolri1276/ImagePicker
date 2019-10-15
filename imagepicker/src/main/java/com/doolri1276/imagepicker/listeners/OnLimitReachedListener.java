package com.doolri1276.imagepicker.listeners;

import android.content.Context;

public interface OnLimitReachedListener {
    void limitActionPerformed(Context context, int imageSize, int limit);
}

package com.doolri1276.imagepicker.features;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;

import com.doolri1276.imagepicker.R;
import com.doolri1276.imagepicker.features.cameraonly.CameraOnlyConfig;
import com.doolri1276.imagepicker.helper.ConfigUtils;
import com.doolri1276.imagepicker.helper.IpLogger;
import com.doolri1276.imagepicker.helper.LocaleManager;
import com.doolri1276.imagepicker.helper.StringUtils;
import com.doolri1276.imagepicker.helper.ViewUtils;
import com.doolri1276.imagepicker.model.Folder;
import com.doolri1276.imagepicker.model.Image;

import java.util.List;

public class ImagePickerActivity extends AppCompatActivity implements ImagePickerInteractionListener, ImagePickerView {

    private ActionBar actionBar;
    private ImagePickerFragment imagePickerFragment;

    private ImagePickerConfig config;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleManager.updateResources(newBase));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setResult(RESULT_CANCELED);

        /* This should not happen */
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            IpLogger.getInstance().e("This should not happen. Please open an issue!");
            finish();
            return;
        }
        config = getIntent().getExtras().getParcelable(ImagePickerConfig.class.getSimpleName());
        CameraOnlyConfig cameraOnlyConfig = getIntent().getExtras().getParcelable(CameraOnlyConfig.class.getSimpleName());

        boolean isCameraOnly = cameraOnlyConfig != null;

        // TODO extract camera only function so we don't have to rely to Fragment
        if (!isCameraOnly) {
            setTheme(config.getTheme());
            setContentView(R.layout.ef_activity_image_picker);
            setupView();
        } else {
            setContentView(createCameraLayout());
        }

        if (savedInstanceState != null) {
            // The fragment has been restored.
            imagePickerFragment = (ImagePickerFragment) getSupportFragmentManager().findFragmentById(R.id.ef_imagepicker_fragment_placeholder);
        } else {
            imagePickerFragment = ImagePickerFragment.newInstance(config, cameraOnlyConfig);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.ef_imagepicker_fragment_placeholder, imagePickerFragment);
            ft.commit();
        }
    }

    private FrameLayout createCameraLayout() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.ef_imagepicker_fragment_placeholder);
        return frameLayout;
    }

    /**
     * Create option menus.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(menu.size()>0)
            menu.getItem(0).setTitle(StringUtils.getINSTANCE().getCamera(getApplicationContext()));
        getMenuInflater().inflate(R.menu.ef_image_picker_menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuCamera = menu.findItem(R.id.menu_camera);
        if (menuCamera != null) {
            if (config != null) {
                menuCamera.setVisible(imagePickerFragment.isShowCameraButton(config));
            }
        }

        MenuItem menuDone = menu.findItem(R.id.menu_done);
        if (menuDone != null) {
            menuDone.setTitle(ConfigUtils.getDoneButtonText(this, config));
            menuDone.setVisible(imagePickerFragment.isShowDoneButton());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Handle option menu's click event
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        if (id == R.id.menu_done) {
            imagePickerFragment.onDone();
            return true;
        }
        if (id == R.id.menu_camera) {
            imagePickerFragment.captureImageWithPermission();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!imagePickerFragment.handleBack()) {
            super.onBackPressed();
        }
    }

    private void setupView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        if (actionBar != null) {
            final Drawable arrowDrawable = ViewUtils.getArrowIcon(this);
            final int arrowColor = config.getArrowColor();
            if (arrowColor != ImagePickerConfig.NO_COLOR && arrowDrawable != null) {
                arrowDrawable.setColorFilter(arrowColor, PorterDuff.Mode.SRC_ATOP);
            }
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(arrowDrawable);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    /* --------------------------------------------------- */
    /* > ImagePickerInteractionListener Methods */
    /* --------------------------------------------------- */

    @Override
    public void setTitle(String title) {
        actionBar.setTitle(title);
        supportInvalidateOptionsMenu();
    }

    @Override
    public void cancel() {
        finish();
    }

    @Override
    public void selectionChanged(List<Image> imageList) {
        // Do nothing when the selection changes.
    }

    @Override
    public void finishPickImages(Intent result) {
        setResult(RESULT_OK, result);
        finish();
    }

    /* --------------------------------------------------- */
    /* > View Methods  */
    /* --------------------------------------------------- */

    @Override
    public void showLoading(boolean isLoading) {
        imagePickerFragment.showLoading(isLoading);
    }

    @Override
    public void showFetchCompleted(List<Image> images, List<Folder> folders) {
        imagePickerFragment.showFetchCompleted(images, folders);
    }

    @Override
    public void showError(Throwable throwable) {
        imagePickerFragment.showError(throwable);
    }

    @Override
    public void showEmpty() {
        imagePickerFragment.showEmpty();
    }

    @Override
    public void showCapturedImage() {
        imagePickerFragment.showCapturedImage();
    }

    @Override
    public void finishPickImages(List<Image> images) {
        imagePickerFragment.finishPickImages(images);
    }
}

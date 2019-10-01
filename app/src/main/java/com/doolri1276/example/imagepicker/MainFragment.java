package com.doolri1276.example.imagepicker;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.doolri1276.imagepicker.features.ImagePicker;
import com.doolri1276.imagepicker.features.ReturnMode;
import com.doolri1276.imagepicker.model.Image;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.img_fragment);

        view.findViewById(R.id.button_pick_fragment)
                .setOnClickListener(view1 -> {
                    ImagePicker.create(MainFragment.this)
                            .returnMode(ReturnMode.ALL) // set whether pick action or camera action should return immediate result or not. Only works in single mode for image picker
                            .folderMode(true) // set folder mode (false by default)
                            .single()
                            .toolbarFolderTitle("Folder") // folder selection title
                            .toolbarImageTitle("Tap to select")
                            .toolbarDoneButtonText("DONE") // done button text
                            .start(0); // image selection title
                });

        view.findViewById(R.id.button_close)
                .setOnClickListener(view12 -> getFragmentManager().beginTransaction()
                        .remove(MainFragment.this)
                        .commitAllowingStateLoss());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        List<Image> images = ImagePicker.getImages(data);
        if (images != null && !images.isEmpty()) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(images.get(0).getPath()));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

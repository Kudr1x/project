package com.example.project.reg;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.example.project.R;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class infoUser extends Fragment {

    CircleImageView imageView;
    Uri image;
    Button start;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_user, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imageProfile);
        start = view.findViewById(R.id.start);

        imageView.setOnClickListener(view1 -> loadImage());
        start.setOnClickListener(view1 -> goToMainActivity());
    }

    private void goToMainActivity() {
        //todo check data
        Navigation.findNavController(getView()).navigate(R.id.action_infoUser_to_mainActivity);
    }

    private void loadImage() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet2layout);

        Button btGall = dialog.findViewById(R.id.gallery);
        Button btCam = dialog.findViewById(R.id.cam);

            //Фото из галереии
        btGall.setOnClickListener(view -> {
            ImagePicker.with(this).galleryOnly().crop().start();
            dialog.cancel();
        });

            //Фото с камеры
        btCam.setOnClickListener(view -> {
            ImagePicker.with(this).cameraOnly().crop().start();
            dialog.cancel();
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        image = data.getData();
        Picasso.get().load(image).into(imageView);
    }
}
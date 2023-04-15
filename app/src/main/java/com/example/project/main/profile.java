package com.example.project.main;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.project.R;
import com.example.project.util.newAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class profile extends Fragment {

    private ConstraintLayout cars;
    private ArrayList<String> arr = new ArrayList<>();
    private SharedPreferences sPref;    //Сохранение данных


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cars = view.findViewById(R.id.cars);

        loadCars();

        cars.setOnClickListener(view1 -> openMyCars(arr));
    }

    private void loadCars() {

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String s = sharedPreferences.getString("key", null);
        if (s != null) {
            Gson gson = new Gson();
            String[] arrString = gson.fromJson(s, String[].class);
            for(String i : arrString){
                arr.add(i);
            }
        }
    }

    private void openMyCars(ArrayList<String> arr){
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet3layout);

        EditText editText = dialog.findViewById(R.id.newCars);
        ImageView check = dialog.findViewById(R.id.check);
        RecyclerView recyclerView = dialog.findViewById(R.id.recDialog);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);

        check.setOnClickListener(view -> {
            String car = editText.getText().toString();

            if(car.length() == 0){
                editText.setError("Введите название");
                return;
            }

            if(car.length() > 30){
                editText.setError("Слишком большое название");
                return;
            }

            arr.add(car);
            newAdapter adapter = new newAdapter(arr, getContext());
            recyclerView.setAdapter(adapter);

            SharedPreferences sharedPreferences = getContext().getSharedPreferences("sp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            Gson gson = new Gson();
            String s = gson.toJson(arr);
            editor.putString("key", s);
            editor.commit();

            editText.setText("");
        });

        newAdapter adapter = new newAdapter(arr, getContext());
        recyclerView.setAdapter(adapter);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}
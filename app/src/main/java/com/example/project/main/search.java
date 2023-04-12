package com.example.project.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.util.SelectListenerString;
import com.example.project.util.carsAdapter;
import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.util.ArrayList;
import java.util.Date;

public class search extends Fragment implements SelectListenerString {

    Button user;
    Button driver;
    Button add;
    Button all;
    Dialog dialog;
    RecyclerView recyclerView;
    boolean flag = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = view.findViewById(R.id.user);
        driver = view.findViewById(R.id.driver);
        add = view.findViewById(R.id.add);
        all = view.findViewById(R.id.all);

        driver.setOnClickListener(view1 -> flag = false);
        user.setOnClickListener(view1 -> flag = true);

        add.setOnClickListener(view1 -> {
            new SingleDateAndTimePickerDialog.Builder(getContext())
                    .bottomSheet()
                    .curved()
                    .mustBeOnFuture()
                    .displayMinutes(true)
                    .displayHours(true)
                    .displayDays(false)
                    .displayMonth(true)
                    .displayYears(true)
                    .displayDaysOfMonth(true)
                    .title("Выберите дату")
                    .listener(new SingleDateAndTimePickerDialog.Listener() {
                        @Override
                        public void onDateSelected(Date date) {
                                Toast.makeText(getActivity(), date.toString(), Toast.LENGTH_SHORT).show();
                                if(flag){
                                    Toast.makeText(getActivity(), "Готово", Toast.LENGTH_SHORT).show();
                                }else{
                                    dialog = new Dialog(getContext());
                                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                    dialog.setContentView(R.layout.bottomsheetlayout);

                                    recyclerView = dialog.findViewById(R.id.recDialog);
                                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                                    recyclerView.setLayoutManager(mLayoutManager);
                                    createAdapter();

                                    dialog.show();
                                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                    dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                                    dialog.getWindow().setGravity(Gravity.BOTTOM);
                                }
                        }
                    })
                    .display();
        });

        all.setOnClickListener(view1 -> {
            Intent i = new Intent(getActivity().getBaseContext(), allTrips.class);
            i.putExtra("flag", flag);
            getActivity().startActivity(i);
        });
    }

    @Override
    public void onItemClicked(String string) {
        Toast.makeText(getActivity(), "Вы поедите на " + string, Toast.LENGTH_SHORT).show();
        dialog.cancel();
        //todo
    }

    void createAdapter(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Приора");
        arr.add("Гелик");
        recyclerView.setAdapter(new carsAdapter(arr, this, getActivity()));
    }
}
package com.example.project.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.project.R;
import com.example.project.util.Elements;
import com.example.project.util.RecAdapter;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;

public class history extends Fragment {

    RecyclerView rec;
    RecAdapter adapter;
    Button active;
    Button history;
    private final ArrayList<Elements> arr = new ArrayList<>();
    private final ArrayList<Elements> mas = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rec = view.findViewById(R.id.rec);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        rec.setLayoutManager(mLayoutManager);

        active = view.findViewById(R.id.active);
        history = view.findViewById(R.id.history);

        mas.add(new Elements());
        mas.add(new Elements());
        mas.add(new Elements());
        mas.add(new Elements());
        mas.add(new Elements());


        arr.add(new Elements());
        arr.add(new Elements());
        arr.add(new Elements());
        arr.add(new Elements());
        arr.add(new Elements());
        arr.add(new Elements());
        arr.add(new Elements());

        adapter = new RecAdapter(mas, getActivity());
        rec.setAdapter(adapter);

        active.setOnClickListener(view1 -> {
            adapter = new RecAdapter(mas, getActivity());
            rec.setAdapter(adapter);
        });
        history.setOnClickListener(view1 -> {
            adapter = new RecAdapter(arr, getActivity());
            rec.setAdapter(adapter);
        });
    }
}
package com.example.project.reg;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.R;

public class loginUser extends Fragment {

    TextView goToReg;
    Button login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goToReg = view.findViewById(R.id.goToRegFragment);
        login = view.findViewById(R.id.login);

        goToReg.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.action_loginUser_to_regUser));
        login.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_loginUser_to_mainActivity);
            getActivity().finish();
        });
    }
}
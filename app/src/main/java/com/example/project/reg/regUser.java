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

public class regUser extends Fragment {

    Button reg;
    TextView goToLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reg = view.findViewById(R.id.reg);
        goToLogin = view.findViewById(R.id.goToLoginFragment);

        reg.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.action_regUser_to_infoUser));
        goToLogin.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.action_regUser_to_loginUser));
    }
}
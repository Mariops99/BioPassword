package com.marioprieto.biopassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment  implements PasswordAdapter.OnPasswordListener{

    PasswordAdapter passwordAdapter;
    RecyclerView recyclerView;
    TextView noPassword;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        noPassword = (TextView) view.findViewById(R.id.noPassword);

        passwordAdapter = new PasswordAdapter(getContext(), this);
        recyclerView.setAdapter(passwordAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(view.getContext());
        linearLayoutManager2.setReverseLayout(true);
        linearLayoutManager2.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager2);
        SQLiteController sqLiteController = new SQLiteController(getContext());
        ArrayList<Password> array = sqLiteController.getPassword();
        if(array.size() > 0) {
            System.out.println(array.get(0).getID());
            noPassword.setVisibility(View.GONE);
        }
        passwordAdapter.addPasswords(array);
    }

    @Override
    public void onPasswordClick(int position) {
        Toast.makeText(getContext(), "Tocado" + position, Toast.LENGTH_SHORT).show();
    }
}

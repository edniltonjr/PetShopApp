package com.example.juniorsantos.petshopapp.activities;

import android.os.Bundle;

import com.example.juniorsantos.petshopapp.R;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpNavDrawer();
    }
}

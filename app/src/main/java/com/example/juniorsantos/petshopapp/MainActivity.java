package com.example.juniorsantos.petshopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpNavDrawer();
    }
}

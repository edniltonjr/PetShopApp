package com.example.juniorsantos.petshopapp;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

public class BasicActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    protected void setUpToolbar() {
        Toolbar t = findViewById(R.id.toolbar);
        if (t != null) {
            setSupportActionBar(t);
        }
    }

    protected void setUpNavDrawer() {
        drawerLayout = null;
        NavigationView navigationView = null;
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
            drawerLayout = findViewById(R.id.drawerLayout);
        }

        if (drawerLayout != null) {
            navigationView = findViewById(R.id.navigationView);

            if (navigationView != null) {
                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        onNavItemSelected(item);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
            }
        }

    }

    private void onNavItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item1:
                break;

            case R.id.item2:
                break;

            case R.id.item3:
                break;

            case R.id.item4:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}

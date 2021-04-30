package com.prasadthegreat.interntask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mbottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavView);
        mbottomNavigationView.setBackground(null);
        Menu menuNav=mbottomNavigationView.getMenu();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new orderfragment()).commit();
        mbottomNavigationView.setOnNavigationItemSelectedListener(bottomnavMethod);
    }


    private  BottomNavigationView.OnNavigationItemSelectedListener bottomnavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment=null;
                    switch (item.getItemId()){

                        case R.id.order:
                            fragment=new orderfragment();
                            break;
                        case R.id.donate:
                            fragment=new donatefragment();
                            break;
                        case R.id.history:
                            fragment=new Historyfragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                }
            };
}
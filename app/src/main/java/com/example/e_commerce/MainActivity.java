package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_buttons);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        //            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();




////        if (savedInstanceState == null) {
//            MainFragment mainFragment = MainFragment.newInstance();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setReorderingAllowed(true);  //сортирует фрагменты в своем неведомом порядке (андроид)
//            fragmentTransaction.replace(R.id.fragment_main, mainFragment, "mainFragment");
//            fragmentTransaction.commitNow();   //коммитит в гланом потоке, сразу же
////        }
    }

    public void to_home(MenuItem item) {
//        navController.popBackStack();
    }
}




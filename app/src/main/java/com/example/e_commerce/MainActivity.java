package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import kotlin.collections.ArrayDeque;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    NavController navController;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_buttons);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navHostFragment.getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int count = navHostFragment.getChildFragmentManager().getBackStackEntryCount();
                if(count == 0){
//                    navController.na
                    Log.d(TAG, "onBackStackChanged: first fragment opened" + count);
                }
                else{
                    Log.d(TAG, "onBackStackChanged: other fragment opened" + count);
                }
            }
        });
        //            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();




////        if (savedInstanceState == null) {
//            MainFragment mainFragment = MainFragment.newInstance();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setReorderingAllowed(true);  //сортирует фрагменты в своем неведомом порядке (андроид)
//            fragmentTransaction.replace(R.id.fragment_main, mainFragment, "mainFragment");
//            fragmentTransaction.commitNow();   //коммитит в гланом потоке, сразу же
////        }
    }
}




package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_buttons);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        NavController navController = navHostFragment.getNavController();
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

//    public void toCart(View view) {
//        OrderFragment orderFragment = new OrderFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setReorderingAllowed(true);
//        fragmentTransaction.setCustomAnimations(
//                R.anim.from_right,
//                R.anim.to_left,
//                R.anim.from_left,
//                R.anim.to_right);
//        fragmentTransaction.hide(this.getSupportFragmentManager().findFragmentByTag("mainFragment"));
//        fragmentTransaction.add(R.id.fragment_main, orderFragment, null);
//        fragmentTransaction.addToBackStack(null);     // чтобы не выходить из приложения кнопкой назад
//        fragmentTransaction.commit();
//    }
}




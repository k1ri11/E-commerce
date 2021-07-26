package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.e_commerce.model.MainFragment;
import com.example.e_commerce.model.OrderFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MainFragment mainFragment = MainFragment.newInstance();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_main, mainFragment, "mainFragment");
            fragmentTransaction.commitNow();
        }
    }

    public void toCart(View view) {
        OrderFragment orderFragment = new OrderFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(this.getSupportFragmentManager().findFragmentByTag("mainFragment"));
        fragmentTransaction.add(R.id.fragment_main, orderFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.e_commerce.model.Course;
import com.example.e_commerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);
        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCoursesList) {
            int a = c.getId();
            if (Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle);
        orders_list.setAdapter(adapter);

        ImageButton cleanCartBtn = findViewById(R.id.clean_cart);
        cleanCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order.items_id.clear();
                coursesTitle.clear();
                ((ArrayAdapter<?>) adapter).notifyDataSetChanged();
            }
        });
    }
}
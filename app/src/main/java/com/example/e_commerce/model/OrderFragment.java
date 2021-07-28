package com.example.e_commerce.model;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.e_commerce.R;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        ListView orders_list = view.findViewById(R.id.orders_list);
        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainFragment.fullCoursesList) {
            int a = c.getId();
            if (Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        ListAdapter adapter = new ArrayAdapter<> (getContext(), android.R.layout.simple_list_item_1, coursesTitle );
        orders_list.setAdapter(adapter);

        ImageButton cleanCartBtn = view.findViewById(R.id.clean_cart);
        cleanCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order.items_id.clear();
                coursesTitle.clear();
                ((ArrayAdapter<?>) adapter).notifyDataSetChanged();
            }
        });
        return view;
    }
}
package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView CategoryRV;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add( new Category(1,"Игры"));
        categoryList.add( new Category(2,"Сайты"));
        categoryList.add( new Category(3,"Языки"));
        categoryList.add( new Category(4,"Прочее"));

        setCategoryRV(categoryList);
    }

    private void setCategoryRV(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        CategoryRV = findViewById(R.id.category_rv);
        CategoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList );
        CategoryRV.setAdapter(categoryAdapter);
    }
}
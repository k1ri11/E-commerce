package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView CategoryRV, courseRV;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

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

        List<Course> courseList = new ArrayList<>();
        courseList.add( new Course(1, "java", "Профессия Java\nразработчик", "1 Января", "начальный", "#424345", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));
        courseList.add( new Course(1, "python", "Профессия Python\nразработчик", "20 Февраля", "начальный", "#9FA52D", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));
        courseList.add( new Course(1, "back_end", "Профессия Back-End\nразработчик", "25 Мая", "средний", "#4476D6", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));
        courseList.add( new Course(1, "front_end", "Профессия Front-End\nразработчик", "8 Июня", "начальный", "#F16A51", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));
        courseList.add( new Course(1, "full_stack", "Профессия Full-Stack\nразработчик", "1 Сентября", "средний", "#0D0F29",getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));
        courseList.add( new Course(1, "unity", "Профессия Unity\nразработчик", "25 Ноября", "начальный", "#FD896A", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2)));

        setcourseRV(courseList);
    }

    private void setcourseRV(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        courseRV = findViewById(R.id.course_rv);
        courseRV.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList );
        courseRV.setAdapter(courseAdapter);
    }

    private void setCategoryRV(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        CategoryRV = findViewById(R.id.category_rv);
        CategoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList );
        CategoryRV.setAdapter(categoryAdapter);
    }
}
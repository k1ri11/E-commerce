package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;
import com.example.e_commerce.model.Category;
import com.example.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView CategoryRV, courseRV;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    static View previousClick = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        categoryList.add( new Category(0,"Все"));
        categoryList.add( new Category(1,"Игры"));
        categoryList.add( new Category(2,"Сайты"));
        categoryList.add( new Category(3,"Языки"));
        categoryList.add( new Category(4,"Прочее"));

        setCategoryRV(categoryList);
        courseList.add( new Course(1, "java", "Профессия Java\nразработчик", "1 Января", "начальный", "#424345", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 3));
        courseList.add( new Course(2, "python", "Профессия Python\nразработчик", "20 Февраля", "начальный", "#9FA52D", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 3));
        courseList.add( new Course(3, "back_end", "Профессия Back-End\nразработчик", "25 Мая", "средний", "#4476D6", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2),2));
        courseList.add( new Course(4, "front_end", "Профессия Front-End\nразработчик", "8 Июня", "начальный", "#F16A51", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 2));
        courseList.add( new Course(5, "full_stack", "Профессия Full-Stack\nразработчик", "1 Сентября", "средний", "#0D0F29",getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 2));
        courseList.add( new Course(6, "unity", "Профессия Unity\nразработчик", "25 Ноября", "начальный", "#FD896A", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2),1));

        fullCoursesList.addAll(courseList);

        setcourseRV(courseList);
    }

    private void setcourseRV(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        courseRV = findViewById(R.id.course_rv);
        courseRV.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList );
        courseRV.setAdapter(courseAdapter);
    }

    public void openCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCategoryRV(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        CategoryRV = findViewById(R.id.category_rv);
        CategoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList );
        CategoryRV.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category){
        List<Course> filterCourses = new ArrayList<>();
        courseList.clear();
        if (category == 0){
            courseList.addAll(fullCoursesList);
        }
        else {
            for (Course c : fullCoursesList) {
                if (c.getCategory() == category)
                    filterCourses.add(c);
            }
            courseList.addAll(filterCourses);
        }
        courseAdapter.notifyDataSetChanged();
    }

    public static void  setTextColorClicked(View v){
        TextView categoryTitle = v.findViewById(R.id.category_title);
        categoryTitle.setTextColor(Color.parseColor("#EC6D6D"));
        if (previousClick != null){
            TextView categoryTitlePrevoius = previousClick.findViewById(R.id.category_title);
            categoryTitlePrevoius.setTextColor(Color.parseColor("#000000"));
        }
        previousClick = v;
    }

}

package com.example.e_commerce.model;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.e_commerce.R;
import com.example.e_commerce.adapter.CategoryAdapter;
import com.example.e_commerce.adapter.CourseAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment implements CourseAdapter.itemClickListener {

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    RecyclerView CategoryRV, courseRV;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    public static List<Course> fullCoursesList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    static View previousClick = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        categoryList.add( new Category(0,"Все"));
        categoryList.add( new Category(1,"Игры"));
        categoryList.add( new Category(2,"Сайты"));
        categoryList.add( new Category(3,"Языки"));
        categoryList.add( new Category(4,"Прочее"));

        courseList.add( new Course(1, "java", "Профессия Java\nразработчик", "1 Января", "начальный", "#424345", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 3));
        courseList.add( new Course(2, "python", "Профессия Python\nразработчик", "20 Февраля", "начальный", "#9FA52D", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 3));
        courseList.add( new Course(3, "back_end", "Профессия Back-End\nразработчик", "25 Мая", "средний", "#4476D6", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2),2));
        courseList.add( new Course(4, "front_end", "Профессия Front-End\nразработчик", "8 Июня", "начальный", "#F16A51", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 2));
        courseList.add( new Course(5, "full_stack", "Профессия Full-Stack\nразработчик", "1 Сентября", "средний", "#0D0F29",getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2), 2));
        courseList.add( new Course(6, "unity", "Профессия Unity\nразработчик", "25 Ноября", "начальный", "#FD896A", getResources().getString(R.string.course_page__course_desc) , getResources().getString(R.string.course_page__course_desc_2),1));


        fullCoursesList.addAll(courseList);

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initCourseRv(view);

        CategoryRV = view.findViewById(R.id.category_rv);
        setCategoryRV(categoryList);

        return view;
    }


    @Override
    public void onItemClick(Course course){
        Fragment coursePageFragment = CoursePageFragment.newInstance(
                course.getDate(), course.getLevel(), course.getTitle(), course.getText1(),
                course.getText2(), course.getImg(), course.getBgColor(), course.getId());

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.from_left,
                R.anim.to_right,
                R.anim.from_right,
                R.anim.to_left);
        fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("mainFragment"));
        fragmentTransaction.add(R.id.fragment_main, coursePageFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void initCourseRv(View view){
        courseRV = view.findViewById(R.id.course_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(),RecyclerView.HORIZONTAL,false);
        courseRV.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this.getContext(), courseList, this);
        courseRV.setAdapter(courseAdapter);
    }

    private void setCategoryRV(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(),RecyclerView.HORIZONTAL,false);

        CategoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this.getContext(), categoryList );
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
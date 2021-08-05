package com.example.e_commerce;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.model.Order;


public class CoursePageFragment extends Fragment {
//    private static final String ARG_DATE = "Date";
//    private String Date;
//    public static CoursePageFragment newInstance(String Date) {
//        CoursePageFragment fragment = new CoursePageFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_DATE, Date);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            Date = getArguments().getString(ARG_DATE);
//        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_course_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        int Item_Id = CoursePageFragmentArgs.fromBundle(getArguments()).getItemID();
        String Title = CoursePageFragmentArgs.fromBundle(getArguments()).getTitle();
        String Text_1 = CoursePageFragmentArgs.fromBundle(getArguments()).getText1();
        String Text_2 = CoursePageFragmentArgs.fromBundle(getArguments()).getText2();
        String Date = CoursePageFragmentArgs.fromBundle(getArguments()).getDate();
        String Level = CoursePageFragmentArgs.fromBundle(getArguments()).getLevel();
        String BGColor = CoursePageFragmentArgs.fromBundle(getArguments()).getBGColor();
        String Image = CoursePageFragmentArgs.fromBundle(getArguments()).getImage();

        ConstraintLayout courseBG = view.findViewById(R.id.course_page__course_bg);
        ImageView courseImage = view.findViewById(R.id.course_page__course_img);
        TextView courseTitle = view.findViewById(R.id.course_page__title);
        TextView courseDate = view.findViewById(R.id.course_page__date);
        TextView courseLevel = view.findViewById(R.id.course_page__level);
        TextView courseText1 = view.findViewById(R.id.course_page_first_p);
        TextView courseText2 = view.findViewById(R.id.course_page_second_p);
        ImageButton addBtn = view.findViewById(R.id.add_to_cart);

        courseDate.setText(Date);
        courseLevel.setText(Level);
        courseTitle.setText(Title);
        courseText1.setText(Text_1);
        courseText2.setText(Text_2);
        courseBG.setBackgroundColor(Color.parseColor(BGColor));
        int ImageId = getContext().getResources().getIdentifier("ic_" + Image, "drawable", getContext().getPackageName());
        courseImage.setImageResource(ImageId);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order.items_id.add(Item_Id);
                Toast.makeText(getContext(), "Добавлено!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
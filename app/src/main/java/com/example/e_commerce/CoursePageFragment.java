package com.example.e_commerce;

import android.graphics.Color;
import android.os.Bundle;

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
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DATE = "Date";
    private static final String ARG_LEVEL = "Level";
    private static final String ARG_TITLE = "Title";
    private static final String ARG_TEXT_1 = "Text_1";
    private static final String ARG_TEXT_2 = "Text_2";
    private static final String ARG_BG_COLOR = "BGColor";
    private static final String ARG_IMAGE = "Image";
    private static final String ARG_ID = "Item_Id";

    private String Date;
    private String Level;
    private String Title;
    private String Text_1;
    private String Text_2;
    private String BGColor;
    private String Image;
    private int Item_Id;

    public static CoursePageFragment newInstance(String Date, String Level, String Title, String Text_1,
                                                 String Text_2, String Image, String BGColor, int Item_Id ) {
        CoursePageFragment fragment = new CoursePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DATE, Date);
        args.putString(ARG_LEVEL, Level);
        args.putString(ARG_TITLE, Title);
        args.putString(ARG_TEXT_1, Text_1);
        args.putString(ARG_TEXT_2, Text_2);
        args.putString(ARG_BG_COLOR, BGColor);
        args.putString(ARG_IMAGE, Image);
        args.putInt(ARG_ID, Item_Id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Date = getArguments().getString(ARG_DATE);
            Level = getArguments().getString(ARG_LEVEL);
            Title = getArguments().getString(ARG_TITLE);
            Text_1 = getArguments().getString(ARG_TEXT_1);
            Text_2 = getArguments().getString(ARG_TEXT_2);
            BGColor = getArguments().getString(ARG_BG_COLOR);
            Image = getArguments().getString(ARG_IMAGE);
            Item_Id = getArguments().getInt(ARG_ID);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_page, container, false);

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

//                ImageView cartBtn = view.findViewById(R.id.button_cart);
//        cartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(R.id.action_to_cart);
//            }
//        });

        return view;
    }
}
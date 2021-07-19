package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class activity_course_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBG = findViewById(R.id.course_page__course_bg);
        ImageView courseImage = findViewById(R.id.course_page__course_img);
        TextView courseTitle = findViewById(R.id.course_page__title);
        TextView courseDate = findViewById(R.id.course_page__date);
        TextView courseLevel = findViewById(R.id.course_page__level);
        TextView courseText1 = findViewById(R.id.course_page_first_p);
        TextView courseText2 = findViewById(R.id.course_page_second_p);

        courseBG.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText1.setText(getIntent().getStringExtra("courseText1"));
        courseText2.setText(getIntent().getStringExtra("courseText2"));


        

    }
}
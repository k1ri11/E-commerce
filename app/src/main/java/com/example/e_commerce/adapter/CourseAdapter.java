package com.example.e_commerce.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce.R;
import com.example.e_commerce.activity_course_page;
import com.example.e_commerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>  {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item,parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        holder.cardBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getBgColor()));

        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImg.setImageResource(imageId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activity_course_page.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity)context,
                        new Pair<View, String>(holder.courseImg, "courseImage")
                );

                intent.putExtra("courseBg", (Color.parseColor(courses.get(position).getBgColor())));
                intent.putExtra("courseImage", imageId);
                intent.putExtra("courseTitle", courses.get(position).getTitle() );
                intent.putExtra("courseDate", courses.get(position).getDate());
                intent.putExtra("courseLevel", courses.get(position).getLevel());
                intent.putExtra("courseText1", courses.get(position).getText1());
                intent.putExtra("courseText2", courses.get(position).getText2());

                context.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder{

        ImageView courseImg;
        CardView cardBg;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImg = itemView.findViewById(R.id.product_iv);
            cardBg = itemView.findViewById(R.id.card_bg);
            courseTitle = itemView.findViewById(R.id.product_title);
            courseDate = itemView.findViewById(R.id.course_date);
            courseLevel = itemView.findViewById(R.id.course_level);
        }
    }
}

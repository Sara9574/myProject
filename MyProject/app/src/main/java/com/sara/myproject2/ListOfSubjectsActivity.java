package com.sara.myproject2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListOfSubjectsActivity extends AppCompatActivity {



    List<Teacher> teacherList;
    RecyclerView recyclerView;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_subjects);

        toolbarTitle = findViewById(R.id.toolbarTitle);
        String title = getIntent().getStringExtra("title");
        toolbarTitle.setText("اساتید "+title);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teacherList = new ArrayList<>();


        //adding some items to our list
        teacherList.add(
                new Teacher(
                        1,
                        "محمد",
                        "کریمیان",
                        "لیسانس شیمی",
                        5,
                        R.drawable.p1
                        , 30000
                        ,"۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));


        teacherList.add(
                new Teacher(
                        5,
                        "مریم",
                        "بهشتی",
                        "دکترای ادبیات",
                        4,
                        R.drawable.p7,
                        47000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));

        teacherList.add(
                new Teacher(
                        2,
                        "هادی",
                        "خادمی",
                        "دکترای حقوق",
                        4,
                        R.drawable.p6,
                        45000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));

        teacherList.add(
                new Teacher(
                        3,
                        "علی",
                        "رضایی",
                        "دکترای فیزیک",
                        4,
                        R.drawable.p3,
                        65000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));


        teacherList.add(
                new Teacher(
                        4,
                        "خدیجه",
                        "حسینی",
                        "دکترای ریاضی",
                        4,
                        R.drawable.p4,
                        65000,
                        "۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));

        //creating recyclerview adapter
        TeacherAdapter adapter = new TeacherAdapter(this, teacherList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }


}

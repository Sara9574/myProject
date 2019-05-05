package com.sara.myproject2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends android.support.v4.app.Fragment {

    View view;
    List<Comment> commentList;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        commentList = new ArrayList<>();

        commentList.add(new Comment(
                1,
                1,
                2,
                "محمد",
                3,
                "زیاد راضی نبودم واس همین ۳ میدم",
                "۱۲ آبان ۱۳۹۷"

        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "مهسا بابایی",
                5,
                "خیلی عالی بودن ایشان",
                "۵‌آبان ۱۳۹۷"
        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "سامان",
                1,
                "خوب نبود...فقط من خوبم",
                "۵‌آبان ۱۳۹۷"
        ));
        commentList.add(new Comment(
                1,
                1,
                2,
                "محمد",
                3,
                "زیاد راضی نبودم واس همین ۳ میدم",
                "۵‌آبان ۱۳۹۷"
        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "مهسا بابایی",
                5,
                "خیلی عالی بودن ایشان",
                "۵‌آبان ۱۳۹۷"
        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "سامان",
                1,
                "خوب نبود...فقط من خوبم",
                "۵‌آبان ۱۳۹۷"
        ));
        commentList.add(new Comment(
                1,
                1,
                2,
                "محمد",
                3,
                "زیاد راضی نبودم واس همین ۳ میدم",
                "۵‌آبان ۱۳۹۷"
        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "مهسا بابایی",
                5,
                "خیلی عالی بودن ایشان",
                "۵‌آبان ۱۳۹۷"
        ));

        commentList.add(new Comment(
                1,
                1,
                2,
                "سامان",
                1,
                "خوب نبود...فقط من خوبم",
                "۵‌آبان ۱۳۹۷"
        ));

        CommentAdapter cmAdapter = new CommentAdapter(getActivity(),commentList);
        recyclerView.setAdapter(cmAdapter);


    }
}

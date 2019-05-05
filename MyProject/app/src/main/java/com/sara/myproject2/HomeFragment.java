package com.sara.myproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;


import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment {


    List<Teacher> teacherListBest;
    List<Teacher> teacherListNew;
    List<Teacher> teacherListKonkoor;



    RecyclerView recyclerViewBest;
    RecyclerView recyclerViewNew;
    RecyclerView recyclerViewKonkoor;

    LinearLayoutManager layoutManagerBest;
    LinearLayoutManager layoutManagerNew;
    LinearLayoutManager layoutManagerKonkoor;

    SliderLayout mDemoSlider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView toolbarTitle;
        toolbarTitle = view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getString(R.string.bot_home));


        layoutManagerBest = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        mDemoSlider = view.findViewById(R.id.slider);
        recyclerViewBest = view.findViewById(R.id.horizontalRecyclerViewBest);
        recyclerViewBest.setHasFixedSize(true);
        recyclerViewBest.setLayoutManager(layoutManagerBest);



        layoutManagerNew = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        recyclerViewNew = view.findViewById(R.id.horizontalRecyclerViewNew);
        recyclerViewNew.setHasFixedSize(true);
        recyclerViewNew.setLayoutManager(layoutManagerNew);


        layoutManagerKonkoor= new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        recyclerViewKonkoor = view.findViewById(R.id.horizontalRecyclerViewKonkoor);
        recyclerViewKonkoor.setHasFixedSize(true);
        recyclerViewKonkoor.setLayoutManager(layoutManagerKonkoor);



      //  recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        layoutManagerBest.setReverseLayout(true);

        teacherListBest = new ArrayList<>();
        teacherListNew = new ArrayList<>();
        teacherListKonkoor = new ArrayList<>();


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put(" ",R.drawable.slide1);
        file_maps.put("  ",R.drawable.slide2);
        file_maps.put("   ",R.drawable.slide3);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                            Intent intent = new Intent(getActivity(),test.class);
                            startActivity(intent);
                        }
                    });

          //  textSliderView.bundle(new Bundle());
          //  textSliderView.getBundle()
            //         .putString("extra",name);
            mDemoSlider.addSlider(textSliderView);

        }



////////////////////////////////////////////////////////////////////////////////////////////////////////////
        teacherListBest.add(
                new Teacher(
                        1,
                        "محمد",
                        "کریمیان",
                        "لیسانس شیمی",
                        5,
                        R.drawable.p1
                        , 30000
                        ,"۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));

        teacherListBest.add(
                new Teacher(
                        5,
                        "مریم",
                        "بهشتی",
                        "دکترای ادبیات",
                        4,
                        R.drawable.p7,
                        47000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));

        teacherListBest.add(
                new Teacher(
                        2,
                        "هادی",
                        "خادمی",
                        "دکترای حقوق",
                        4,
                        R.drawable.p6,
                        45000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        teacherListNew.add(
                new Teacher(
                        3,
                        "علی",
                        "رضایی",
                        "دکترای فیزیک",
                        4,
                        R.drawable.p3,
                        65000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));


        teacherListNew.add(
                new Teacher(
                        4,
                        "خدیجه",
                        "حسینی",
                        "دکترای ریاضی",
                        4,
                        R.drawable.p4,
                        65000,
                        "۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));
        teacherListNew.add(
                new Teacher(
                        2,
                        "هادی",
                        "خادمی",
                        "دکترای حقوق",
                        4,
                        R.drawable.p6,
                        45000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));
        teacherListNew.add(
                new Teacher(
                        1,
                        "محمد",
                        "کریمیان",
                        "لیسانس شیمی",
                        5,
                        R.drawable.p1
                        , 30000
                        ,"۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));
///////////////////////////////////////////////////////////////////////////////////////////////////////////


        teacherListKonkoor.add(
                new Teacher(
                        4,
                        "خدیجه",
                        "حسینی",
                        "دکترای ریاضی",
                        4,
                        R.drawable.p4,
                        65000,
                        "۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));
        teacherListKonkoor.add(
                new Teacher(
                        1,
                        "محمد",
                        "کریمیان",
                        "لیسانس شیمی",
                        5,
                        R.drawable.p1
                        , 30000
                        ,"۲۵ سال سابقه تجربه در موسسات مختلف از جمله مدرسان شریف"));

        teacherListKonkoor.add(
                new Teacher(
                        2,
                        "هادی",
                        "خادمی",
                        "دکترای حقوق",
                        4,
                        R.drawable.p6,
                        45000,
                        "دکترای ادبیات از دانشگاه تهران و ۱۰ سال سابقه تدریس در دانشگاه"));




        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapterBest= new HorizontalRecyclerViewAdapter(getActivity(),teacherListBest);
        recyclerViewBest.setAdapter(horizontalRecyclerViewAdapterBest);

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapterNew= new HorizontalRecyclerViewAdapter(getActivity(),teacherListNew);
        recyclerViewNew.setAdapter(horizontalRecyclerViewAdapterNew);

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapterKonkoor = new HorizontalRecyclerViewAdapter(getActivity(),teacherListKonkoor);
        recyclerViewKonkoor.setAdapter(horizontalRecyclerViewAdapterKonkoor);
    }}



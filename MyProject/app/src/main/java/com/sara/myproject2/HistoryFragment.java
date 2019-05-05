
package com.sara.myproject2;

        import android.content.Context;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.design.widget.AppBarLayout;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.view.ViewPager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;


public class HistoryFragment extends Fragment {

    List<Session> sessionList;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_history, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView toolbarTitle;
        toolbarTitle = view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText(getString(R.string.bot_history));

        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/bnazanin.ttf");
        toolbarTitle.setTypeface(custom_font);


        recyclerView = view.findViewById(R.id.recyclerView3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        sessionList = new ArrayList<>();


        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                2,
                "۱۲ آذر ۹۷",
                "شیمی",
                "کنکور سراسری",
                "میدان هروی،خیابان ساقدوش",
                "۱۳:۳۰",
                "محمد کریمیان"
        ));

        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                1,
                "۱۲ آذر ۹۷",
                "شیمی",
                "کنکور سراسری",
                "میدان هروی،خیابان ساقدوش",
                "۱۳:۳۰",
                "محمد کریمیان"
        ));

        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                1,
                "۲ آذر ۹۷",
                "ریاضی",
                "کنکور سراسری",
                "میدان هروی،خیابان ساقدوش",
                "۱۳:۳۰",
                "نادر بهرامی"
        ));

        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                2,
                "۲ آذر ۹۷",
                "ریاضی",
                "کنکور سراسری",
                "میدان هروی،خیابان ساقدوش",
                "۱۰:۳۰",
                "نادر بهرامی"
        ));
        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                2,
                "۲ آذر ۹۷",
                "فیزیک",
                "یازدهم",
                "میدان هروی،خیابان ساقدوش",
                "۱۳:۳۰",
                "علی قادری"
        ));
        sessionList.add(new Session(
                1,
                2,
                3,
                2,
                1,
                "۲ آبان ۹۷",
                "ریاضی",
                "کنکور سراسری",
                "میدان هروی،خیابان ساقدوش",
                "۱۳:۳۰",
                "نادر بهرامی"
        ));

        SessionAdapter sessionAdapter= new SessionAdapter(getActivity(),sessionList);
        recyclerView.setAdapter(sessionAdapter);
    }
}
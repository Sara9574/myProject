package com.sara.myproject2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SessionDetailsFragment extends Fragment {
    View view;
    String subject;
    TextView subjectTv;
    TextView toolbarTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_session_details,container,false);
        return view;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        toolbarTitle = view.findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("جزئیات جلسه");

        subjectTv = view.findViewById(R.id.subjectTV);


        if (getArguments() != null) {
            subject   = getArguments().getString("subject");
            subjectTv.setText(subject);

        }
    }
}

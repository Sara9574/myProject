package com.sara.myproject2;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {


    private Context mCtx;
    private List<Session>sessionList;

    public SessionAdapter(Context mCtx, List<Session> sessionList) {
        this.mCtx = mCtx;
        this.sessionList = sessionList;

    }

    @NonNull
    @Override
    public SessionAdapter.SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_sessions, null);
        return new SessionAdapter.SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionAdapter.SessionViewHolder holder, int position) {
        final Session session = sessionList.get(position);
        holder.textViewSubject.setText(session.getSubject());
        holder.textViewGrade.setText(session.getGrade());
        holder.textViewTeacherName.setText(session.getTeacherName());
        holder.textViewTeacherDate.setText(session.getPersianDate());
        if(session.getStatus()==1)
            holder.statusImage.setImageResource(R.drawable.tick);
        else if(session.getStatus()==2)
            holder.statusImage.setImageResource(R.drawable.cancel);


        holder.sessionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle args = new Bundle();
                args.putString("subject", session.getSubject());

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment sessionDetailsFragment = new SessionDetailsFragment();
                sessionDetailsFragment.setArguments(args);


                FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.enter, R.anim.exit);
                ft.replace(R.id.fragment_container, sessionDetailsFragment, "detailFragment");
                ft.addToBackStack(null);
                ft.commit();


                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }


    class SessionViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSubject, textViewGrade,textViewTeacherName,textViewTeacherDate;
        CardView sessionCardView;
        ImageView statusImage;

        public SessionViewHolder(View itemView) {
            super(itemView);

            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewGrade = itemView.findViewById(R.id.textViewGrade);
            textViewTeacherName = itemView.findViewById(R.id.textViewTeacherName);
            textViewTeacherDate = itemView.findViewById(R.id.textViewTeacherDate);
            sessionCardView = itemView.findViewById(R.id.sessionCardView);
            statusImage = itemView.findViewById(R.id.statusImage);
            sessionCardView = itemView.findViewById(R.id.sessionCardView);

            Typeface custom_font = Typeface.createFromAsset(mCtx.getAssets(),  "fonts/bnazanin.ttf");
            textViewSubject.setTypeface(custom_font);
            textViewGrade.setTypeface(custom_font);
            textViewTeacherName.setTypeface(custom_font);
            textViewTeacherDate.setTypeface(custom_font);
        }
    }



}

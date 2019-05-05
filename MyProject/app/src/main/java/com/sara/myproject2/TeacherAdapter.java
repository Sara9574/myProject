package com.sara.myproject2;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import java.io.ByteArrayOutputStream;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private Context mCtx;


    private List<Teacher> teacherList;


    public TeacherAdapter(Context mCtx, List<Teacher> teacherList) {
        this.mCtx = mCtx;
        this.teacherList = teacherList;

    }

    @NonNull
    @Override
    public TeacherAdapter.TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_teachers, null);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TeacherAdapter.TeacherViewHolder holder, int position) {

        final Teacher teacher = teacherList.get(position);

        holder.textViewFirstName.setText(teacher.getFirstName()+" " +teacher.getLastName());
        holder.textViewDegree.setText(String.valueOf(teacher.getDegree()));
        holder.ratingBar.setRating(teacher.getRating());
        holder.textViewPrice.setText(String.valueOf(teacher.getPrice())+" T");
        holder.textViewDescription.setText(String.valueOf(teacher.getDescription()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(teacher.getImage()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bmp = BitmapFactory.decodeResource(mCtx.getResources(), teacher.getImage());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent intent = new Intent(v.getContext(),ProfessorActivity.class);
                intent.putExtra("name",teacher.getFirstName());
                intent.putExtra("lastName",teacher.getLastName());
                intent.putExtra("degree",teacher.getDegree());
                intent.putExtra("description",teacher.getDescription());
                intent.putExtra("price",teacher.getPrice());
                intent.putExtra("rating",teacher.getRating());
                intent.putExtra("picture", byteArray);
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    class TeacherViewHolder extends RecyclerView.ViewHolder {

        TextView textViewFirstName, textViewDegree,textViewPrice, textViewDescription;
        ImageView imageView;
        RatingBar ratingBar;
        CardView cardView;

        public TeacherViewHolder(View itemView) {
            super(itemView);

            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewDegree = itemView.findViewById(R.id.textViewDegree);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageView = itemView.findViewById(R.id.imageView);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            cardView = itemView.findViewById(R.id.cardView);

            Typeface custom_font = Typeface.createFromAsset(mCtx.getAssets(),  "fonts/bnazanin.ttf");

            textViewFirstName.setTypeface(custom_font);
            textViewDegree.setTypeface(custom_font);
            textViewPrice.setTypeface(custom_font);
            textViewDescription.setTypeface(custom_font);

        }
    }
}


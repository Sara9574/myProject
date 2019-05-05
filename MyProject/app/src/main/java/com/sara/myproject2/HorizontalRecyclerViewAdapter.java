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
import android.widget.RatingBar;
import android.widget.TextView;



import java.io.ByteArrayOutputStream;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private Context mCtx;
    private List<Teacher> teacherList;

    public HorizontalRecyclerViewAdapter(Context mCtx, List<Teacher> teacherList) {
        this.mCtx = mCtx;
        this.teacherList = teacherList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_horizantal_listitem, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final Teacher teacher = teacherList.get(position);

        holder.techaerNameHorizList.setText(teacher.getFirstName()+" " +teacher.getLastName());
        holder.degreeHorizItem.setText(String.valueOf(teacher.getDegree()));
        holder.horizListImage.setImageDrawable(mCtx.getResources().getDrawable(teacher.getImage()));
        holder.ratingBarHorizList.setRating(teacher.getRating());
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView horizListImage;
        TextView techaerNameHorizList;
        TextView degreeHorizItem;
        RatingBar ratingBarHorizList;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            horizListImage = itemView.findViewById(R.id.horizListImage);
            techaerNameHorizList = itemView.findViewById(R.id.techaerNameHorizList);
            degreeHorizItem = itemView.findViewById(R.id.degreeHorizItem);
            ratingBarHorizList = itemView.findViewById(R.id.ratingBarHorizList);
            cardView = itemView.findViewById(R.id.horizantalRecyclerViewItem);


            Typeface custom_font = Typeface.createFromAsset(mCtx.getAssets(),  "fonts/bnazanin.ttf");
            techaerNameHorizList.setTypeface(custom_font);
            degreeHorizItem.setTypeface(custom_font);


        }
    }
}

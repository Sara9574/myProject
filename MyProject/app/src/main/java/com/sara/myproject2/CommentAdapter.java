package com.sara.myproject2;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {


    private Context mCtx;
    private List<Comment> commentList;
    public CommentAdapter(Context mCtx, List<Comment> commentList) {
        this.mCtx = mCtx;
        this.commentList = commentList;

    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_comments, null);
        return new CommentAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {

        final Comment comment = commentList.get(position);
        holder.textViewComment.setText(comment.getDescription());
        holder.textViewUserName.setText(comment.getUserName());
        holder.commentRating.setRating(comment.getRating());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewComment, textViewUserName;
        RatingBar commentRating;
        CardView commentCardView;

        public CommentViewHolder(View itemView) {
            super(itemView);
            textViewComment = itemView.findViewById(R.id.textViewComment);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            commentRating = itemView.findViewById(R.id.commentRating);
            commentCardView = itemView.findViewById(R.id.commentCardView);

            Typeface custom_font = Typeface.createFromAsset(mCtx.getAssets(),  "fonts/bnazanin.ttf");
            textViewComment.setTypeface(custom_font);
            textViewUserName.setTypeface(custom_font);

        }
    }

}

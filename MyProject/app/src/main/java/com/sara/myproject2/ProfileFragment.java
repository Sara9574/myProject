package com.sara.myproject2;

        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Typeface;
        import android.media.Image;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;


public class ProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView toolbarTitle;
        toolbarTitle = view.findViewById(R.id.toolbarTitle);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/IRANSans.ttf");
        toolbarTitle.setTypeface(custom_font);

        ImageView editImageView = view.findViewById(R.id.editProfile);
        editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EditProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}


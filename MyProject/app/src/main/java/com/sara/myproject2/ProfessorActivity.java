package com.sara.myproject2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfessorActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private TextView toolbarTitle;
    private TextView fullname;
    private RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("اطلاعات استاد");
        Typeface custom_font = Typeface.createFromAsset(this.getAssets(),  "fonts/bnazanin.ttf");
        toolbarTitle.setTypeface(custom_font);


        Bundle extras = getIntent().getExtras();
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String lastName = getIntent().getStringExtra("lastName");
        float rating = getIntent().getFloatExtra("rating",0);
        String degree = getIntent().getStringExtra("degree");
        int price = getIntent().getIntExtra("price",0);
        byte[] byteArray = extras.getByteArray("picture");


        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image =  findViewById(R.id.proImageView);
        image.setImageBitmap(bmp);

        fullname = findViewById(R.id.teacherNameProPage);
        fullname.setText(name+" "+lastName);
        ratingBar = findViewById(R.id.ratingBarProPage);
        ratingBar.setRating(rating);

        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appbar);
        viewPager = findViewById(R.id.historyViewpager) ;

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Tab1Fragment(),"نظرات شاگردان");
        adapter.AddFragment(new Tab2Fragment(),"درباره استاد");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(1);
    }
}

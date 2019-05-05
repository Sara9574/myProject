package com.sara.myproject2;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView logoName;
    Button signUpBtn;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            findViewById(R.id.button).setVisibility(View.VISIBLE);
            findViewById(R.id.button2).setVisibility(View.VISIBLE);
            findViewById(R.id.progBar).setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        logoName = findViewById(R.id.logoName);
        signUpBtn = findViewById(R.id.button2);
        handler.postDelayed(runnable, 3000);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        logoName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,MainActivity.class );
                startActivity(intent);
            }
        });


    }
}

package com.example.afikoman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button challenge1;
    private Button challenge2;
    private Button challenge3;
    private Button challenge4;
    private Button challenge5;
    private Bundle bundle;
    private int [] array = {0,0,0,0,0};
    private String sns = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        unboxingBundle();
        initView();
        init();


    }

    private void initView() {
        if(sns.equals("")){
            return;
        }else{
            if (array[0] == 1){
                challenge1.setBackgroundColor(Color.parseColor("#00FF00"));
            }if (array[1] == 1){
                challenge2.setBackgroundColor(Color.parseColor("#00FF00"));
            }if (array[2] == 1){
                challenge3.setBackgroundColor(Color.parseColor("#00FF00"));
            }if (array[3] == 1){
                challenge4.setBackgroundColor(Color.parseColor("#00FF00"));
            }if (array[4] == 1){
                challenge5.setBackgroundColor(Color.parseColor("#00FF00"));
            }
        }
    }

    private void unboxingBundle() {
        try {
            bundle = getIntent().getExtras().getBundle("BUNDLE");
            sns = bundle.getString("CHALLENGE");
            array = bundle.getIntArray("ARR");
        }catch (Exception e){

        }
    }

    private void init() {
        challenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame("challenge1");
            }
        });

        challenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame("challenge2");
            }
        });

        challenge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame("challenge3");
            }
        });

        challenge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame("challenge4");
            }
        });

        challenge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame("challenge5");
            }
        });

    }

    private void startGame(String sns) {
        Intent myIntent = new Intent();
        Bundle bundle = initBundleData(sns);
        myIntent = new Intent(this, Challenge1.class);
        myIntent.putExtra("BUNDLE", bundle);
        startActivity(myIntent);
        MainActivity.this.finish();
    }

    private Bundle initBundleData(String sns) {
        Bundle bundle = new Bundle();
        bundle.putIntArray("ARR",array);
        bundle.putString("CHALLENGE", sns);
        return bundle;
    }

    private void findViews() {
        challenge1 = findViewById(R.id.menu_BTN_ch1);
        challenge2 = findViewById(R.id.menu_BTN_ch2);
        challenge3 = findViewById(R.id.menu_BTN_ch3);
        challenge4 = findViewById(R.id.menu_BTN_ch4);
        challenge5 = findViewById(R.id.menu_BTN_ch5);

    }
}
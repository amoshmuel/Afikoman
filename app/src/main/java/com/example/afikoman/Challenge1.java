package com.example.afikoman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Challenge1 extends AppCompatActivity {
    private Button submit;
    private EditText flag;
    private Bundle bundle;
    private Bundle bundleCorrect;
    private String challenge;
    private int [] array = {0,0,0,0,0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1);
        findViews();
        unboxingBundle();
        init();

    }

    private void unboxingBundle() {
        bundle = getIntent().getExtras().getBundle("BUNDLE");
        challenge = bundle.getString("CHALLENGE");
        array = bundle.getIntArray("ARR");
    }


    private void init() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(flag.getText().toString())) {
                    Toast.makeText(Challenge1.this, "Enter Flag", Toast.LENGTH_LONG).show();
                } else {
                    if(challenge.equals("challenge1")){
                        if(flag.getText().toString().equals("Afikoman{kaveret_he_kol_kah_yafa}")){
                            Toast.makeText(Challenge1.this, "Correct!", Toast.LENGTH_LONG).show();
                            array[0] = 1;
                            startGame();
                        }else{
                            Toast.makeText(Challenge1.this, "Wrong Flag", Toast.LENGTH_LONG).show();
                        }

                    }else if(challenge.equals("challenge2")){
                        if(flag.getText().toString().equals("Afikoman{hadag_nahash_ze_hazman_lehitorer}")){
                            Toast.makeText(Challenge1.this, "Correct!", Toast.LENGTH_LONG).show();
                            array[1] = 1;
                            startGame();
                        }else{
                            Toast.makeText(Challenge1.this, "Wrong Flag", Toast.LENGTH_LONG).show();
                        }

                    }else if(challenge.equals("challenge3")){
                        if(flag.getText().toString().equals("Afikoma{mashina_rakevet_layla_lekahir}")){
                            Toast.makeText(Challenge1.this, "Correct!", Toast.LENGTH_LONG).show();
                            array[2] = 1;
                            startGame();
                        }else{
                            Toast.makeText(Challenge1.this, "Wrong Flag", Toast.LENGTH_LONG).show();
                        }

                    }else if(challenge.equals("challenge4")){
                        if(flag.getText().toString().equals("Afikoman{shoshana_damari_or}")){
                            Toast.makeText(Challenge1.this, "Correct!", Toast.LENGTH_LONG).show();
                            array[3] = 1;
                            startGame();
                        }else{
                            Toast.makeText(Challenge1.this, "Wrong Flag", Toast.LENGTH_LONG).show();
                        }

                    }else if(challenge.equals("challenge5")){
                        if(flag.getText().toString().equals("")){
                            Toast.makeText(Challenge1.this, "Correct!", Toast.LENGTH_LONG).show();
                            array[4] = 1;
                            startGame();
                        }else{
                            Toast.makeText(Challenge1.this, "Wrong Flag", Toast.LENGTH_LONG).show();
                        }

                    }
                }
            }
        });
    }

    private void startGame() {
        Intent myIntent = new Intent();
        Bundle bundleCorrect = initBundleData();
        myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("BUNDLE", bundle);
        startActivity(myIntent);
        Challenge1.this.finish();
    }

    private Bundle initBundleData() {
        Bundle bundleCorrect = new Bundle();
        bundleCorrect.putString("CHALLENGE", flag.getText().toString());
        bundleCorrect.putIntArray("ARR", array);
        return bundleCorrect;
    }
    private void findViews() {
        submit = findViewById(R.id.challenge_BTN_submit);
        flag = findViewById(R.id.challenge_ET_flag);
    }
}
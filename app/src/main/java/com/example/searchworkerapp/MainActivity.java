package com.example.searchworkerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBuilder,btneditcv,btnsearchworker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuilder = findViewById(R.id.btnbuilder);
        btneditcv = findViewById(R.id.btneditcv);
        btnsearchworker = findViewById(R.id.btnsearchworker);


        btnBuilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent object = new Intent(MainActivity.this,Builder.class);
                startActivity(object);
            }
        });

        btneditcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent object = new Intent(MainActivity.this,Profile.class);
                startActivity(object);
            }
        });

        btnsearchworker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent object = new Intent(MainActivity.this,Records.class);
                startActivity(object);
            }
        });


    }
}
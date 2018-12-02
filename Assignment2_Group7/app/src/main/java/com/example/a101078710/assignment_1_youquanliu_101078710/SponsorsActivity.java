package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SponsorsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onClick(View v){
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        findViewById(R.id.btnback).setOnClickListener(this);

    }
}

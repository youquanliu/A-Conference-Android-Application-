package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper mydb;

    @Override
    public void onClick(View v){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DatabaseHelper mydb = new DatabaseHelper(this);

        TextView textName = (TextView)findViewById(R.id.textName);
        TextView textBio = (TextView)findViewById(R.id.textBio);
        TextView textEmail = (TextView)findViewById(R.id.textEmail);
        TextView textAfil = (TextView)findViewById(R.id.textAfil);

        Bundle extras = getIntent().getExtras();
        String dName = extras.getString("key");


        Cursor cursor = mydb.viewOneData(dName);

        while(cursor.moveToNext()){
            textName.setText(cursor.getString(1));
            textEmail.setText(cursor.getString(2));
            textAfil.setText(cursor.getString(3));
            textBio.setText(cursor.getString(4));


        }


        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,SpeakersActivity.class));
            }
        });





    }




}

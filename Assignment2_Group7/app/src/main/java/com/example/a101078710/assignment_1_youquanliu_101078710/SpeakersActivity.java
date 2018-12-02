package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.Intent;

public class SpeakersActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper mydb;

    ListView userlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;





    @Override
    public void onClick(View v){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SpeakersActivity.this,Home.class));
            }
        });

        mydb = new DatabaseHelper(this);

//        Previously Added to Database can convert into a button for user to add manually
//        mydb.insertDB("Jeremy","Oasis","Tester1@hotmail","This guy is COOL");
//        mydb.insertDB("Frank","Nexin","Tester2@hotmail","This guy is awesome");
//        mydb.insertDB("John","GBC","Tester3@hotmail","This dude is okay");
//        mydb.insertDB("Huskie","Doge","Tester4@hotmail","This Dog is RAD");


        listItem = new ArrayList<>();

        userlist = findViewById(R.id.users_list);

        viewData();


        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userlist.getItemAtPosition(i).toString();
                Toast.makeText(SpeakersActivity.this,text,Toast.LENGTH_SHORT).show();
                listItem.clear();
                viewData();
                startActivity(new Intent(SpeakersActivity.this,DetailActivity.class));

                Intent j = new Intent(SpeakersActivity.this,DetailActivity.class);
                j.putExtra("key",text);
                startActivity(j);
            }
        });



    }



    private void viewData(){
        Cursor cursor = mydb.viewData();

        if (cursor.getCount()==0){
            Toast.makeText(this,"no Data to show",Toast.LENGTH_SHORT).show();;
        } else{
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            userlist.setAdapter(adapter);
        }
    }

}

package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    TextView displaytext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SurveyActivity.class);
                startActivity(i);
            }
        });

        usernameInput = (EditText) findViewById(R.id.username);
        displaytext = (TextView) findViewById(R.id.textView);

    }
    //Save the user login User Name
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());

        editor.apply();
        Toast.makeText(this,"Saved!",Toast.LENGTH_LONG).show();
    }
    //Print out the saved user name
    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username","");
        displaytext.setText("welcome " + name + "!");

    }



}

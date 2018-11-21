package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;


public class SurveyActivity extends AppCompatActivity {
    private static final String FILE_NAME = "survey.txt";
    EditText mEditText,mEditText2,mEditText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        mEditText = findViewById(R.id.edit_text);
        mEditText2 = findViewById(R.id.edit_text2);
        mEditText3 = findViewById(R.id.edit_text3);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Home.class);
                startActivity(i);
            }
        });




    }
    public void Save(View v) {
        String text = mEditText.getText().toString();
        String text2 = mEditText2.getText().toString();
        String text3 = mEditText3.getText().toString();

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.write(text2.getBytes());
            fos.write(text3.getBytes());


            mEditText.getText().clear();
            mEditText2.getText().clear();
            mEditText3.getText().clear();

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Load(View v) {
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy\nhh-mm-ss a");
        String dateString = sdf.format(date);

        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(dateString).append("\t\t\t").append(text).append("\n\t");
            }

            mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

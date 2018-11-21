package com.example.a101078710.assignment_1_youquanliu_101078710;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;

public class Home extends AppCompatActivity {

//    static final int MY_CONTACT_TAG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //The map button
       findViewById(R.id.btnMaps).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=60+harbour+St+Toronto"));

               startActivity(i);
           }
       });
       //The GeneralSchedule button
       findViewById(R.id.btnGeneralSchedule).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(v.getContext(), GeneralScheduleActivity.class);
               startActivity(i);
           }
       });
        //The MySchedule button
        findViewById(R.id.btnMySchedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MyScheduleActivity.class);
                startActivity(i);
            }
        });
        //The Speakers button
        findViewById(R.id.btnSpeakers).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SpeakersActivity.class);
                startActivity(i);
            }
        });

        //The Sponsors button
        findViewById(R.id.btnSponsors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SponsorsActivity.class);
                startActivity(i);
            }
        });
        //The Attendees button
        findViewById(R.id.btnAttendees).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AttendeesActivity.class);
                startActivity(i);
            }
        });

//       //The Attendees button
//       findViewById(R.id.btnAttendees).setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent i = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
//               i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//               startActivityForResult(i,MY_CONTACT_TAG);
//           }
//       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if(requestCode == MY_CONTACT_TAG){
//            if(requestCode == RESULT_OK){
//
//                Uri uri = data.getData();
//                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
//
//                Cursor c = getContentResolver().query(uri, projection, null, null, null);
//                c.moveToFirst();
//
//                int col = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//                String number = c.getString(col);
//                ((TextView)findViewById(R.id.textView).setText(number));
//
//            }
//        }
    }
}

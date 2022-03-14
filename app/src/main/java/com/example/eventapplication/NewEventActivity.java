package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class NewEventActivity extends AppCompatActivity {

    Button addNewEvent;
    EventDb db;
    EditText eventName;
    EditText eventTime;
    EditText eventVenue;
    EditText eventInfo;
    EditText eventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        addNewEvent = findViewById(R.id.addnewevent);
        eventName = findViewById(R.id.eventname);
        eventInfo = findViewById(R.id.eventinfo);
        eventTime = findViewById(R.id.eventtime);
        eventVenue = findViewById(R.id.eventvenue);
        eventDate = findViewById(R.id.eventdate);
        db = new EventDb(this);
        addNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle extras = getIntent().getExtras();
                String user = extras.getString("username");
                String nameOfEvent = eventName.getText().toString();
                String info = eventInfo.getText().toString();
                String time = eventTime.getText().toString();
                String venue = eventVenue.getText().toString();
                String date = eventDate.getText().toString();
                String tag = "NewEventActivity";
                Log.v(tag,"User:"+user+",nameOfEvent:"+nameOfEvent+",info:"+info+",time:"+time+",venue:"+nameOfEvent+",date:"+date);
                Boolean result = db.insertEventData(user,nameOfEvent,info,date,time,venue);
                if(result==true)
                {
                    Toast.makeText(NewEventActivity.this,"Event Added Successfully",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(NewEventActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                };
            }
        });
    }
}
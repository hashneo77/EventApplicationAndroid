package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.eventapplication.databinding.ActivityEventBinding;
import com.example.models.events;
import com.example.models.userprofile;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    String userName;
    LoginDb loginDb ;
    EventDb eventDb;
    Button addEvent,deleteEvent,editProfile,logout;
    ArrayAdapter arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventBinding activityEventBinding = DataBindingUtil.setContentView(this,R.layout.activity_event);
        addEvent = findViewById(R.id.addevent);
        editProfile = findViewById(R.id.editprofile);
        listView = findViewById(R.id.list_events);
        deleteEvent = findViewById(R.id.dltevent);
        logout = findViewById(R.id.profilelogout);
        loginDb = new LoginDb(this);
        eventDb = new EventDb(this);
        ArrayList<userprofile> userprofileArrayList = new ArrayList<>();
        ArrayList<events> eventsArrayList = null;


        Bundle extras = getIntent().getExtras();
        String user = extras.getString("username");



        if(extras!=null)
        {
            userprofileArrayList = loginDb.fetchData(user);
            if(userprofileArrayList!=null){
                activityEventBinding.setUseremail(userprofileArrayList.get(0).getEmail());
                activityEventBinding.setUserphone(userprofileArrayList.get(0).getPhone());
                activityEventBinding.setUserprofile(userprofileArrayList.get(0).getUsername());
            }
        }

//        viewdata(user);

        eventsArrayList = eventDb.readEventsData(user);
        ArrayList<String> eventNames = new ArrayList();
        if(eventsArrayList.size()>0){
            for(events event :eventsArrayList)
                eventNames.add(event.getEventName());
        }
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,eventNames);
        listView.setAdapter(arrayAdapter);


        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                String user = extras.getString("username");
                Intent i3 = new Intent(getApplicationContext(),NewEventActivity.class);
                i3.putExtra("username",user);
                startActivity(i3);
            }
        });


    }

//    public void viewdata(String user){
//
//        return;
//    }



}

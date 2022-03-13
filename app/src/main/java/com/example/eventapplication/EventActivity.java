package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.eventapplication.databinding.ActivityEventBinding;
import com.example.models.userprofile;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    String userName;
    LoginDb loginDb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventBinding activityEventBinding = DataBindingUtil.setContentView(this,R.layout.activity_event);

        loginDb = new LoginDb(this);
        ArrayList<userprofile> userprofileArrayList;
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            userprofileArrayList = loginDb.fetchData(extras.getString("username"));
            if(userprofileArrayList!=null){
                activityEventBinding.setUseremail(userprofileArrayList.get(0).getEmail());
                activityEventBinding.setUserphone(userprofileArrayList.get(0).getPhone());
                activityEventBinding.setUserprofile(userprofileArrayList.get(0).getUsername());
            }
        }


    }
}
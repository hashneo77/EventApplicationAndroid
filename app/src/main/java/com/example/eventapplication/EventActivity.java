package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EventActivity extends LoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }
}
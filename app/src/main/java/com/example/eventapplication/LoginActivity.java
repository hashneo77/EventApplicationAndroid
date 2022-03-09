package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText username;
    EditText password;
    Button signIn;
    DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signIn = findViewById(R.id.signin1);
        dBhelper = new DBhelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Intent i = new Intent(getApplicationContext(), EventActivity.class);
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                    if (dBhelper.checkUsernameAndPassword(user, pass) == true) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
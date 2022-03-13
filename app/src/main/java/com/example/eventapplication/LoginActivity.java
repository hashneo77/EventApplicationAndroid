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
    LoginDb loginDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signIn = findViewById(R.id.signlogin);
        loginDb = new LoginDb(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (!TextUtils.isEmpty(user) || !TextUtils.isEmpty(pass)) {
                    if (loginDb.checkUsernameAndPassword(user, pass) == true) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i2 = new Intent(getApplicationContext(), EventActivity.class);
                        i2.putExtra("username",user);
                        startActivity(i2);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }
}
package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signIn,register;
    EditText username,password;
    LoginDb loginDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn = findViewById(R.id.start_signin);
        register = findViewById(R.id.start_register);
        username = findViewById(R.id.start_username);
        password = findViewById(R.id.start_password);
        loginDb = new LoginDb(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (!TextUtils.isEmpty(user) || !TextUtils.isEmpty(pass)) {
                    if (loginDb.checkUsernameAndPassword(user, pass) == true) {
                        Intent i2 = new Intent(getApplicationContext(), EventActivity.class);
                        i2.putExtra("username",user);
                        startActivity(i2);
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(i);
            }
        });
    }
}
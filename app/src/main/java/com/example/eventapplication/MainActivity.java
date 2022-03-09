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

    EditText userName,password,rePassword;
    Button signUp,signIn;
    DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.repassword);
        signIn = findViewById(R.id.signin);
        signUp = findViewById(R.id.signup);

        dBhelper = new DBhelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String repass = rePassword.getText().toString();

                if(TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass))
                    Toast.makeText(MainActivity.this ,"All fields are required",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        if(dBhelper.checkUsername(user)==false){
                            Boolean insert = dBhelper.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"User created Successfully",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                            }
                            else
                                Toast.makeText(MainActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(MainActivity.this,"User Already Registered",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Passwords do not Match",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EventActivity.class);
                startActivity(i);
            }
        });
    }
}
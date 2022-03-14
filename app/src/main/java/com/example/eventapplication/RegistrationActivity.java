package com.example.eventapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText userName,password,rePassword,email,phone,firstname,lastname,org;
    Button signUp;
    LoginDb loginDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        org = findViewById(R.id.org);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        rePassword = findViewById(R.id.repassword);
        signUp = findViewById(R.id.signup);

        loginDb = new LoginDb(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String repass = rePassword.getText().toString();
                String first = firstname.getText().toString();
                String last = lastname.getText().toString();
                String ph = phone.getText().toString();
                String emailId = email.getText().toString();
                String organisation = org.getText().toString();

                if(TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass) || TextUtils.isEmpty(first)|| TextUtils.isEmpty(last)|| TextUtils.isEmpty(ph) || TextUtils.isEmpty(emailId) || TextUtils.isEmpty(organisation))
                    Toast.makeText(RegistrationActivity.this ,"All fields are required",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        if(loginDb.checkUsername(user)==false){
                            Boolean insert = loginDb.insertData(user,pass,first,last,emailId,ph,organisation);
                            if(insert==true){
                                Toast.makeText(RegistrationActivity.this,"User created Successfully",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                            }
                            else
                                Toast.makeText(RegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(RegistrationActivity.this,"User Already Registered",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistrationActivity.this,"Passwords do not Match",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
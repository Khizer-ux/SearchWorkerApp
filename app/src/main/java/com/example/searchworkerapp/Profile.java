package com.example.searchworkerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {

    EditText etprofilemail,etprofilepassword;
    Button btnlogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        etprofilemail = findViewById(R.id.etprofilemail);
        etprofilepassword = findViewById(R.id.etprofilepassword);
        btnlogin = findViewById(R.id.btnlogin);

        final String pemail = etprofilemail.getText().toString().trim();
        String ppassword = etprofilepassword.getText().toString().trim();

        if(pemail.isEmpty()||ppassword.isEmpty())
        {
            Toast.makeText(Profile.this,"please enter data to register",Toast.LENGTH_SHORT).show();
        }
        else
        {
            auth.signInWithEmailAndPassword(pemail,ppassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent object = new Intent(Profile.this,Records.class);
                                object.putExtra("value",pemail);
                                startActivity(object);

                            }
                            else
                            {
                                Toast.makeText(Profile.this,"Authentication Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

    }
}
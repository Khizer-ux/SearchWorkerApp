package com.example.searchworkerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Builder extends AppCompatActivity {

    EditText etbuildname,etbuildfname,etbuilddob,etbuildcontact,etbuildaddress,etbuildemail,etbuildpassword,etbuildedu,etbuildprojects,etbuildresearch,etbuildskill;
    Button btnbuildgenerate;
    DatabaseReference dbref;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);

        etbuildname = findViewById(R.id.etbuildname);
        etbuildfname = findViewById(R.id.etbuildfname);
        etbuilddob = findViewById(R.id.etbuilddob);
        etbuildcontact = findViewById(R.id.etbuildcontact);
        etbuildaddress = findViewById(R.id.etbuildaddress);
        etbuildemail = findViewById(R.id.etbuildemail);
        etbuildpassword = findViewById(R.id.etbuildpassword);
        etbuildedu = findViewById(R.id.etbuildedu);
        etbuildprojects = findViewById(R.id.etbuildprojects);
        etbuildresearch = findViewById(R.id.etbuildresearch);
        etbuildskill = findViewById(R.id.etbuildskill);
        btnbuildgenerate = findViewById(R.id.btnbuildgenerate);

        dbref = FirebaseDatabase.getInstance().getReference("User");


        btnbuildgenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etbuildname.getText().toString().trim();
                String fname = etbuildfname.getText().toString().trim();
                String dob = etbuilddob.getText().toString().trim();
                String contact = etbuildcontact.getText().toString().trim();
                String address = etbuildaddress.getText().toString().trim();
                String email = etbuildemail.getText().toString().trim();
                String password = etbuildpassword.getText().toString().trim();
                String edu = etbuildedu.getText().toString().trim();
                String projects = etbuildprojects.getText().toString().trim();
                String research = etbuildresearch.getText().toString().trim();
                String skill = etbuildskill.getText().toString().trim();
                String id;


                id= dbref.push().getKey();
                Users user= new Users(name, fname, dob, contact, address, email, password, edu, projects, research, skill);
                dbref.child(id).setValue(user);

                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Builder.this,"User created successfully",Toast.LENGTH_SHORT).show();

                                    Intent Object = new Intent(Builder.this,Profile.class);
                                    startActivity(Object);
                                }
                                else
                                {
                                    Toast.makeText(Builder.this,"Error",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
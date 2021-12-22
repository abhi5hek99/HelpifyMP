package com.patel.helpifymp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.patel.helpifymp.Models.Users;
import com.patel.helpifymp.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {

    ActivityCreateAccountBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(CreateAccountActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("wait for a while");


        binding.btnCreateNewAccountCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.etEmail.getText().toString().trim().isEmpty() || binding.etNameCA.getText().toString().trim().isEmpty() || binding.etAgeCA.getText().toString().trim().isEmpty() || binding.etMobileCA.getText().toString().trim().isEmpty() || binding.etPassword.getText().toString().trim().isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Enter all Details", Toast.LENGTH_SHORT).show();
                } else if (binding.etMobileCA.getText().toString().trim().length() != 10) {
                    Toast.makeText(CreateAccountActivity.this, "Enter rightly formatted Mobile Number", Toast.LENGTH_SHORT).show();
                } else {

                    progressDialog.show();

                    auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Users user = new Users(binding.etNameCA.getText().toString(), binding.etAgeCA.getText().toString(), binding.etMobileCA.getText().toString(), binding.etEmail.getText().toString(), binding.etPassword.getText().toString());

                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).child("LoginDetails").setValue(user);


                                Toast.makeText(CreateAccountActivity.this, "Account Created", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(CreateAccountActivity.this, HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(CreateAccountActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
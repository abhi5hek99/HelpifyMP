package com.patel.helpifymp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.patel.helpifymp.Models.Users;
import com.patel.helpifymp.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference reference;
    String uid;
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        uid = FirebaseAuth.getInstance().getUid();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(uid).child("LoginDetails");
        getDetails();

        binding.editDetailsButton.setOnClickListener(v -> {
            String str = binding.editDetailsButton.getText().toString();
            if (str.equals("EDIT DETAILS")) {
                binding.editDetailsButton.setText("Save Changes");
                binding.editTextTextPersonName.setEnabled(true);
                binding.editTextAge.setEnabled(true);
                binding.editTextPhone.setEnabled(true);
                binding.editTextTextEmailAddress3.setEnabled(true);
                binding.editTextTextPassword2.setEnabled(true);
            } else {

                if (binding.editTextAge.getText().toString().trim().isEmpty() || binding.editTextTextPersonName.getText().toString().trim().isEmpty()
                        || binding.editTextAge.getText().toString().trim().isEmpty() || binding.editTextPhone.getText().toString().trim().isEmpty() || binding.editTextTextPassword2.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ProfileActivity.this, "Enter all Details", Toast.LENGTH_SHORT).show();
                } else if (binding.editTextPhone.getText().toString().trim().length() != 10) {
                    Toast.makeText(ProfileActivity.this, "Enter rightly formatted Mobile Number", Toast.LENGTH_SHORT).show();
                }else{
                    Users userToAdd = new Users(binding.editTextTextPersonName.getText().toString(),
                            binding.editTextAge.getText().toString(),
                            binding.editTextPhone.getText().toString(),
                            binding.editTextTextEmailAddress3.getText().toString(),
                            binding.editTextTextPassword2.getText().toString());

                    reference.setValue(userToAdd).addOnCompleteListener(task -> {
                        Toast.makeText(ProfileActivity.this, "Details updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                    }).addOnFailureListener(e -> {
                        Toast.makeText(ProfileActivity.this, "Error Found " + e.toString(), Toast.LENGTH_SHORT).show();
                    });
                }
            }
        });
    }

    void getDetails(){
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Users user = snapshot.getValue(Users.class);
                setUI(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void setUI(Users user){
        binding.editTextTextPersonName.setText(user.getUsername());
        binding.editTextAge.setText(user.getUserage());
        binding.editTextPhone.setText(user.getUsermobile());
        binding.editTextTextEmailAddress3.setText(user.getUseremail());
        binding.editTextTextPassword2.setText(user.getUserpassword());


    }
}
package com.patel.helpifymp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.patel.helpifymp.Models.EmergencyContacts;
import com.patel.helpifymp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements ClickListener {

    FirebaseAuth auth;
    DatabaseReference reference;
    String authId;

    int contactCount;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        authId = FirebaseAuth.getInstance().getUid();
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getSosContact();
            }
        }, 200);


        binding.ivFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Calling Fire Department", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "101" +
                        ""));
                requireContext().startActivity(intent);
            }
        });

        binding.ivAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Calling Ambulance", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "102" +
                        ""));
                requireContext().startActivity(intent);
            }
        });

        binding.ivPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Calling Police Department", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "100" +
                        ""));

                requireContext().startActivity(intent);
            }
        });

        binding.ivSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sending Messages", Toast.LENGTH_SHORT).show();
            }
        });

        binding.fabtnAddContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Adding New Emergency Contacts", Toast.LENGTH_SHORT).show();
                openEmergencyContactDialog();
            }
        });


        return binding.getRoot();
    }

    private void openEmergencyContactDialog() {

        EmergencyContactDialog ecd = new EmergencyContactDialog();
        ecd.show(getChildFragmentManager(), null);
    }

    void getSosContact(){

        String number = FirebaseAuth.getInstance().getUid();

        if(number.equals("")){
            Toast.makeText(requireContext(), "Number Invalid", Toast.LENGTH_SHORT).show();
            return;
        }

        reference = FirebaseDatabase.getInstance().getReference("Users/" + number).child("EmergencyContacts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                ArrayList<EmergencyContacts> contacts = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    EmergencyContacts contact = snapshot.getValue(EmergencyContacts.class);
                    contacts.add(contact);
                }

                setUI(contacts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getDetails(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    void setUI(ArrayList<EmergencyContacts> list){

        if(list.isEmpty()){
            Toast.makeText(getContext(), "No Emergency Contact Added", Toast.LENGTH_SHORT).show();
            binding.recyclerEmergency.setVisibility(View.GONE);
            return;
        }
        binding.recyclerEmergency.setVisibility(View.VISIBLE);
        EmergencyContactAdapter adapter = new EmergencyContactAdapter(list, getContext(), this);
        binding.recyclerEmergency.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        binding.recyclerEmergency.setAdapter(adapter);
    }

    @Override
    public void onClick(String contact) {
        reference.child(contact).removeValue();
        getSosContact();
    }
}




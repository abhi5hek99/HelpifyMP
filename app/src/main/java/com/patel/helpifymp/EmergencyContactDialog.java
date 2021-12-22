package com.patel.helpifymp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.patel.helpifymp.Models.EmergencyContacts;
import com.patel.helpifymp.Models.Users;

public class EmergencyContactDialog extends AppCompatDialogFragment {


    FirebaseDatabase database;
    DatabaseReference reference;

    private EditText editTextName;
    private EditText editTextMobile;
    private EditText editTextRelation;

    String ECDname, ECDMobile, ECDRelation;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String userid= FirebaseAuth.getInstance().getUid();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Users").child(userid).child("EmergencyContacts");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_emergency_contact_dialog, null);
        final int[] count = {0};
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                count[0] =(int) snapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        builder.setView(view).setTitle("Adding Emergency Contacts").setMessage("Enter following details");
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Works", Toast.LENGTH_SHORT).show();
                ECDname = editTextName.getText().toString();
                ECDMobile = editTextMobile.getText().toString();
                ECDRelation = editTextRelation.getText().toString();

                if(count[0]==3){
                    Toast.makeText(getContext(), "Emergency Contact already 3", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    EmergencyContacts EC = new EmergencyContacts(ECDname,ECDMobile,ECDRelation);
                    reference.child(EC.contact).setValue(EC);

                }




            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "works", Toast.LENGTH_SHORT).show();
            }
        });

        editTextName = view.findViewById(R.id.etECName);
        editTextMobile = view.findViewById(R.id.etECMobile);
        editTextRelation = view.findViewById(R.id.etECRelation);

        EmergencyContacts ec = new EmergencyContacts(ECDname, ECDMobile, ECDRelation);



        return builder.create();
    }
}

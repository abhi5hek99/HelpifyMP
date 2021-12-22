package com.patel.helpifymp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MentalHealthTips2Activity extends AppCompatActivity {

    TextView Pname,Ptip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health_tips2);

        ActionBar actionBar = getSupportActionBar();

        Pname = findViewById(R.id.tvPname);
        Ptip= findViewById(R.id.tvPtip);

        Intent intent = getIntent();

        String pname = intent.getStringExtra("Pname");
        String ptip = intent.getStringExtra("Ptip");

        actionBar.setTitle(pname);

        Pname.setText(pname);
        Ptip.setText(ptip);
    }
}
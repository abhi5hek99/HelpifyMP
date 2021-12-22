package com.patel.helpifymp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.patel.helpifymp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    FirebaseAuth auth;

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,new HomeFragment()).commit();


        bnv=(BottomNavigationView)findViewById(R.id.bottomNav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp=null;

                switch (item.getItemId()){

                    case R.id.menu_home:temp = new HomeFragment();
                    break;

                    case R.id.menu_nearbyplaces:temp = new NearbyPlacesFragment();
                    break;

                    case R.id.menu_mental:temp = new MentalFragment();
                    break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FrameContainer,temp).commit();



                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profilemenu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_profile:
                Toast.makeText(HomeActivity.this, "Opening Profile", Toast.LENGTH_SHORT).show();
                Intent intenti = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intenti);
                break;

            case R.id.item_logout:
                auth.signOut();
                Intent intentj = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intentj);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
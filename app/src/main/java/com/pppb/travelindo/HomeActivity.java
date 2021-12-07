package com.pppb.travelindo;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.pppb.travelindo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private LoginFragment loginFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.setSupportActionBar(this.binding.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.binding.drawerLayout, this.binding.toolbar, R.string.openDrawer, R.string.closeDrawer);
        actionBarDrawerToggle.syncState();

        this.loginFragment = LoginFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.add(this.binding.fragmentContainer.getId(), this.loginFragment).addToBackStack(null);
        fragmentTransaction.commit();

    }
}
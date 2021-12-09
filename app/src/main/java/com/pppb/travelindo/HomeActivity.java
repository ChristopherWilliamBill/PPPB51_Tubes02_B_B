package com.pppb.travelindo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.pppb.travelindo.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private LoginFragment loginFragment;
    private HomeFragment homeFragment;
    private FragmentManager fragmentManager;
    private String token;
    private String username;

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

        this.getSupportFragmentManager().setFragmentResultListener("changePage", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int page = result.getInt("page");
                changePage(page);
            }
        });

        this.getSupportFragmentManager().setFragmentResultListener("setToken", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                token = result.getString("token");
                username = result.getString("username");
            }
        });

    }

    private void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page == 1){
            this.homeFragment = HomeFragment.newInstance(this.token, this.username);
            ft.replace(this.binding.fragmentContainer.getId(), homeFragment).addToBackStack(null);
        }
        ft.commit();
    }

    //test commit di gitlab
}
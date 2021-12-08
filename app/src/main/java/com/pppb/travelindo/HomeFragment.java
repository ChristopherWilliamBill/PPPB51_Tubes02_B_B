package com.pppb.travelindo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pppb.travelindo.databinding.HomeFragmentBinding;
import com.pppb.travelindo.databinding.LoginFragmentBinding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;
    private TravelAPI travelAPI;
    private String username;

    public HomeFragment(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://devel.loconode.com/pppb/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.travelAPI = retrofit.create(TravelAPI.class);
    }

    public static HomeFragment newInstance(String token, String username){
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("token", token);
        args.putString("username", username);

        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = HomeFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        this.binding.tvWelcome.setText("Welcome, " + this.getArguments().getString("username"));
        return view;
    }
}

package com.pppb.travelindo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pppb.travelindo.databinding.NavigationFragmentBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NavigationFragment extends Fragment implements View.OnClickListener{
    private NavigationFragmentBinding binding;

    public NavigationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = NavigationFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.btnHome.setOnClickListener(this);
        binding.btnHistory.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnHome){

        }
    }
}


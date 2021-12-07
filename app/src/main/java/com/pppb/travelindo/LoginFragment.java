package com.pppb.travelindo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pppb.travelindo.databinding.LoginFragmentBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment implements View.OnClickListener{
    private LoginFragmentBinding binding;
    private TravelAPI travelAPI;

    public LoginFragment(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://devel.loconode.com/pppb/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.travelAPI = retrofit.create(TravelAPI.class);
    }

    public static LoginFragment newInstance(){
        LoginFragment loginFragment = new LoginFragment();
        Bundle args = new Bundle();
        loginFragment.setArguments(args);

        return loginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = LoginFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        this.binding.btnLogin.setOnClickListener(this);

        return view;
    }

    private void doLogIn(){
        User user = new User(this.binding.etUsername.getText().toString(), this.binding.etPassword.getText().toString());

        Call<User> call = travelAPI.logIn(this.binding.etUsername.getText().toString(), this.binding.etPassword.getText().toString());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Log.d("Response", "failed");
                }

                User userResponse = response.body();
                Log.d("Response", userResponse.getToken());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Response", t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == this.binding.btnLogin){
            this.doLogIn();
        }
    }
}

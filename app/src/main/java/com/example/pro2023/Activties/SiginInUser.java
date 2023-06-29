package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pro2023.Apis.RetrofitSignIn;
import com.example.pro2023.R;
import com.example.pro2023.model.Result;
import com.example.pro2023.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiginInUser extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout EmailTextInput ,PasswordTextInput;
    private Button SignIn;
    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_in_user);
        setup();
        setOnClick();

     /*   SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SiginInUser.this,MainActivity.class);
                startActivity(intent);
            }
        });*/
    }

    private void setOnClick() {
        SignIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    private void setup() {
        EmailTextInput = (TextInputLayout) findViewById(R.id.emailInputId);
        PasswordTextInput = (TextInputLayout) findViewById(R.id.passwordInputId);
        SignIn=findViewById(R.id.signInBtn);
        signUp=(TextView) findViewById(R.id.signUpActivity);
    }

    private  void userSignIn(){
        String email=EmailTextInput.getEditText().getText().toString().trim();
        String password=PasswordTextInput.getEditText().getText().toString().trim();

        Call<Result> call= RetrofitSignIn.getInstance().getMyApi().userLogin(email,password);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(!response.body().getError()) {
                    Intent intent=new Intent(SiginInUser.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Welcome"+response.body().getUser().getName(),Toast.LENGTH_LONG).show();
                    User user=new User((int)response.body().getUser().getId(),response.body().getUser().getName(),response.body().getUser().getEmail(),response.body().getUser().getPassword(),response.body().getUser().getPhone());
                    finish();

                }else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                Log.d("REtotfit Sign In--->",t.getMessage());

            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view==SignIn){
            Toast.makeText(getApplicationContext(),"Connect",Toast.LENGTH_LONG).show();
            userSignIn();
        }else if(view==signUp){
            Intent intent =new Intent(SiginInUser.this,signup.class);
            startActivity(intent);
         }


    }
}
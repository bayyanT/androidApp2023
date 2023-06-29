package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pro2023.R;

public class doctorsDetiels extends AppCompatActivity {
    private TextView doctor;
    private ImageView imgD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_detiels);
        doctor=findViewById(R.id.doctorName);
        imgD=findViewById(R.id.imgDoctors);
        btnHand();

    }

    private void btnHand() {
        final Handler handler =new Handler();
        final  TextView name=findViewById(R.id.doctorName);
        handler.post(new Runnable() {
            @Override
            public void run() {
                Intent intent =getIntent();
                String doctorName=intent.getStringExtra("Name");
                String img=intent.getStringExtra("imgId");
                doctor.setText(doctorName);
                Glide.with(getApplicationContext()).load("http://10.0.2.2/pharmacy/doctors/"+img).apply(new RequestOptions().override(350, 200))
                        .error(R.drawable.notfound)
                        .into(imgD);


            }
        });
    }

    public void btnEmail(View view) {
        /*
         Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"this is a sample app");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Hello There");
        intent.setType("Text/plain");
        Intent chooser =Intent.createChooser(intent,null);
        startActivity(chooser);
         */

        Intent intent =new Intent(doctorsDetiels.this,EmailActivity.class);
        startActivity(intent);




    }

    public void btnPhone(View view) {
        Intent intent =new Intent(Intent.ACTION_CALL);
        intent.putExtra(Intent.EXTRA_TEXT,"this is a sample app");
    }
}
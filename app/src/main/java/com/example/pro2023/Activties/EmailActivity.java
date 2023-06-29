package com.example.pro2023.Activties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pro2023.R;
import com.google.android.material.textfield.TextInputLayout;

public class EmailActivity extends AppCompatActivity {
    private TextInputLayout name;
    private  TextInputLayout Email;
    private  TextInputLayout information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        setup();


    }

    private void setup() {
        name=findViewById(R.id.userEmailName);
        Email=findViewById(R.id.userEmailAddress);
        information=findViewById(R.id.userquestion);
    }
    public void btnSend(View view) {
        /*

          Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"this is a sample app");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Hello There");
        intent.setType("Text/plain");
        Intent chooser =Intent.createChooser(intent,null);
        startActivity(chooser);
         */
       // Intent intent2 =new Intent(Intent.ACTION_SEND);

        String nameEmail=name.getEditText().getText().toString();
        String email=Email.getEditText().getText().toString();
        String qus=information.getEditText().getText().toString();
 //validate
        Intent intent2 =new Intent(Intent.ACTION_SEND);
        intent2.putExtra(Intent.EXTRA_TEXT,qus);
        intent2.putExtra(Intent.EXTRA_SUBJECT,nameEmail);
        intent2.putExtra(Intent.EXTRA_EMAIL,email);
        intent2.setType("Text/plain");
        Intent chooser =Intent.createChooser(intent2,null);
        startActivity(chooser);
        finish();



    }


}
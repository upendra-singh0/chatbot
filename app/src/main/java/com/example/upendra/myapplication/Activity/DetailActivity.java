package com.example.upendra.myapplication.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.upendra.myapplication.R;

/**
 * Created by Upendra on 4/9/2017.
 */

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    EditText firstName,lastName,gender;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView) findViewById(R.id.signin);
        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        gender= (EditText) findViewById(R.id.gender);

        prefs = getSharedPreferences("userId", 0);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }

    private void click()
    {
        String fname = firstName.getText().toString().trim();
        if( fname.length()==0) {
            Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        String lname = lastName.getText().toString().trim();
        String sex = gender.getText().toString().trim();

        if(prefs.getInt("userId", 0) == 0) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("userId", 1);
            editor.putString("firstname", fname);
            editor.putString("lastname", lname);
            editor.putString("gender", sex);
            editor.apply();
        }

        // you can use intent also to send above data in a bundle.
        Intent it = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}

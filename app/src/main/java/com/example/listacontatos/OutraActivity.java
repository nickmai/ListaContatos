package com.example.listacontatos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class OutraActivity extends AppCompatActivity {



    TextView  media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }


        media = findViewById(R.id.numberText);



        Intent intent = getIntent();

        Bundle bundle = this.getIntent().getExtras();

        String aMedia = intent.getStringExtra("media");


        media.setText(aMedia);


        actionBar.setTitle("Média");


    }

}

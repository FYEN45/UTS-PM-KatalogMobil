package com.example.katalogkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);


        ImageView gambarMobil = findViewById(R.id.gambar);
        TextView titleMobil = findViewById(R.id.nama);
        TextView deskripsiMobil1 = findViewById(R.id.deskripsi1);
        TextView deskripsiMobil2 = findViewById(R.id.deskripsi2);

        Intent i =getIntent();
        gambarMobil.setImageResource(i.getIntExtra("img",0));
        titleMobil.setText(i.getStringExtra("title"));
        deskripsiMobil1.setText(i.getStringExtra("deskripsi1"));
        if(!i.getStringExtra("deskripsi2").equals("")){
            deskripsiMobil2.setText(i.getStringExtra("deskripsi2"));
        }else{
            deskripsiMobil2.setVisibility(View.INVISIBLE);
        }
    }
}
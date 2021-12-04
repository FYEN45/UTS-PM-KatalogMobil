package com.example.katalogkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeskripsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);


        ImageView gambarMobil = findViewById(R.id.gambar);
        TextView titleMobil = findViewById(R.id.nama);
        TextView deskripsiMobil = findViewById(R.id.deskripsi);

        Intent i =getIntent();
        gambarMobil.setImageResource(i.getIntExtra("img",0));
        titleMobil.setText(i.getStringExtra("title"));
        deskripsiMobil.setText(i.getStringExtra("deskripsi"));

    }
}
package com.example.katalogkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);


        ImageView gambarMobil = findViewById(R.id.gambar);
        TextView titleMobil = findViewById(R.id.nama);
        TextView hargaMobil = findViewById(R.id.harga);
        TextView deskripsiMobil1 = findViewById(R.id.deskripsi1);

        Intent i = getIntent();
        gambarMobil.setImageResource(i.getIntExtra("img", 0));
        titleMobil.setText(i.getStringExtra("title"));
        hargaMobil.setText(i.getStringExtra("harga"));
        deskripsiMobil1.setText(i.getStringExtra("deskripsi1"));
    }
}
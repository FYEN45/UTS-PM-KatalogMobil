package com.example.katalogkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                runLogin();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(r, 3000);

        TextView splashText = findViewById(R.id.textViewSplash);
        splashText.setOnClickListener(v -> {
            handler.removeCallbacks(r);
            runLogin();
        });
    }

    public void runLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
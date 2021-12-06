package com.example.katalogkelompok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity {

    int[] gridimg = {
            R.drawable.mobil0, R.drawable.mobil1, R.drawable.mobil2, R.drawable.mobil3,
            R.drawable.mobil4, R.drawable.mobil5, R.drawable.mobil6, R.drawable.mobil7
    };
    String[] gridtitle = {
            "New Vios", "All New Corolla Altis", "All New Camry", "All New Corolla Altis Hybrid",
            "All New Camry Hybrid", "New Toyota 86", "Toyota GR Supra", "All New Avanza"
    };
    String[] griddeskripsi = {
            "G Type\n" +
                    "Starting from Rp.270.600.000\n" +
                    "\n" +
                    "- Bold Front Bumper\n" +
                    "- Impressive Headlamp\n" +
                    "- BOLD Two-Tone Color Wheel\n" +
                    "- Cutting-Edge Dashboard Design\n" +
                    "- Advanced Audio Device\n" +
                    "- 7 SRS Airbags\n" +
                    "\n" +
                    "E Type\n" +
                    "Starting from Rp.254.100.000\n" +
                    "\n" +
                    "- Bold Front Bumper\n" +
                    "- Cutting-Edge Dashboard Design\n" +
                    "- 7 SRS Airbags","Gasoline Type\n" +
            "Starting from Rp.438.300.000\n" +
            "\n" +
            "- New Front Grille & Bumper Design\n" +
            "- New Rear Bumper & Rear Lamp Design\n" +
            "- Spacious Cabin\n" +
            "- Clearance Sonar System\n" +
            "- Blind Spot Monitor (BSM)\n" +
            "- TNGA (Toyota New Global Architecture) Platform\n" +
            "\n" +
            "\n" +
            "\n" +
            "Hybrid Type\n" +
            "Starting from Rp.506.300.000\n" +
            "\n" +
            "- New Front Grille & Bumper Design\n" +
            "- New Rear Bumper & Rear Lamp Design\n" +
            "- Striking 17\" Ally Wheels\n" +
            "- Luxurious Interior\n" +
            "- Integrated Multimedia System\n" +
            "- TNGA (Toyota New Global Architecture) Platform","Hybrid Type\n" +
            "Starting From Rp.767.000.000\n" +
            "\n" +
            "- Enchanting LED Front Lamp\n" +
            "- Captivating Interior Design\n" +
            "- Exciting Moon Roof\n" +
            "- Convenient Rear Seat Control\n" +
            "- 7 SRS Airbags\n" +
            "- Toyota New Global Architecture (TNGA)","Gasoline Type\n" +
            "Starting from Rp.438.300.000\n" +
            "\n" +
            "- New Front Grille & Bumper Design\n" +
            "- New Rear Bumper & Rear Lamp Design\n" +
            "- Spacious Cabin\n" +
            "- Clearance Sonar System\n" +
            "- Blind Spot Monitor (BSM)\n" +
            "- TNGA (Toyota New Global Architecture) Platform","V Type \n" +
            "Starting from Rp.637.300.000\n" +
            "\n" +
            "- Enchanting LED From Lamp\n" +
            "- New Captivating Interior Design\n" +
            "- New Authentic Titanium Ornamentation\n" +
            "- 7 SRS Airbag\n" +
            "- TNGA (Toyota New Global Architecture) Platform\n" +
            "- Stolen Vehicle Tracking","Starting from Rp.830.000.000\n" +
            "\n" +
            "\n" +
            "- New Front Grille & Bumper Design\n" +
            "- New Headlamp & Fog Lamp Design\n" +
            "- Sporty Dashboard Design\n" +
            "- Enchanced Body Aerodynamics\n" +
            "- Very Low Center of Gravity","Starting from Rp.2.013.820.000\n" +
            "\n" +
            "- Steering Wheel with Steering Switches\n" +
            "- 8 Speed A/T Transmission\n" +
            "- Sporty Multi-Information Display\n" +
            "- 6 Straight Engine with Twin-scroll Turbocharger","E Type\n" +
            "Starting from Rp.206.200.000\n" +
            "\n" +
            "- New Dynamic Head Unit 7\" Display\n" +
            "- New Fascinating LED Rear Combination Lamp Design\n" +
            "- New Dashing 15\" Alloy Wheel Design\n" +
            "- New Comfortable Suspension\n" +
            "- 6 Airbags D/P/S/C\n" +
            "- Hill Start Assist\n" +
            "- 7P Seatbelt Warning\n" +
            "\n" +
            "G Type\n" +
            "Starting from Rp.228.500.000\n" +
            "\n" +
            "- New Bold Front Bumper Design with New Sharp LED Headlamp and new Fog Lamp\n" +
            "- New Dashing 15\" Alloy Wheel Design\n" +
            "- New Fascinating LED Rear Combination With Backdoor Lamp\n" +
            "- New Striking Full Dashboard Design\n" +
            "- New 4\"2 TFT MID\n" +
            "- New Dynamic Head Unit 9\" Display"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonLogout = findViewById(R.id.buttonLogout);
        Button buttonWebsite = findViewById(R.id.buttonWebsite);
        Button buttonUserList = findViewById(R.id.buttonUserList);

        buttonLogout.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        buttonWebsite.setOnClickListener(view -> {
            String url = "https://www.toyota.astra.co.id/home";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        buttonUserList.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, UserListActivity.class);
            startActivity(intent);
        });

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if(fragment == null){
            fragment = FragmentMobil.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment, "")
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }

    }
}
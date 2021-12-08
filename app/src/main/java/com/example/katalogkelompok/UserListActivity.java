package com.example.katalogkelompok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.katalogkelompok.Config.Config;
import com.example.katalogkelompok.Controller.AppController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class UserListActivity extends AppCompatActivity {

    private final String TAG = UserListActivity.class.getSimpleName();
    ListView listview;
    ArrayList<Users> arraylist_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listview = findViewById(R.id.listViewUser);
        getData();

        listview.setOnItemClickListener((parent, view, position, id) -> {
            if (TempUserLoginData.USER_USERNAME.equals("admin")) {
                Intent intent = new Intent(UserListActivity.this, UserUpdateActivity.class);
                intent.putExtra("id", arraylist_data.get(position).getId());
                intent.putExtra("name", arraylist_data.get(position).getName());
                intent.putExtra("email", arraylist_data.get(position).getEmail());
                intent.putExtra("phoneNumber", arraylist_data.get(position).getPhoneNumber());
                intent.putExtra("username", arraylist_data.get(position).getUsername());
                intent.putExtra("password", arraylist_data.get(position).getPassword());
                startActivity(intent);
                finish();
            } else {
                String pesan = "Anda bukan admin!";
                Toast.makeText(UserListActivity.this, pesan, Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent intent_home = new Intent(UserListActivity.this, HomeActivity.class);
                        intent_home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent_home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent_home);
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.menu_userlist:
                        return true;
                    case R.id.menu_contactus:
                        String url = "https://www.toyota.astra.co.id/shopping-tools/contact-us";
                        Intent intent_url = new Intent(Intent.ACTION_VIEW);
                        intent_url.setData(Uri.parse(url));
                        startActivity(intent_url);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void getData() {
        StringRequest strReq = new StringRequest(Request.Method.GET, Config.requestUserList, responses -> {
            try {
                JSONObject response = new JSONObject(responses);
                JSONObject header = response.getJSONObject("data");
                Iterator<String> iterator = header.keys();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    JSONObject item = (JSONObject) header.get(key);

                    Users users = new Users();
                    users.setId(item.getString("id"));
                    users.setName(item.getString("name"));
                    users.setEmail(item.getString("email"));
                    users.setPhoneNumber(item.getString("phoneNumber"));
                    users.setUsername(item.getString("username"));
                    users.setPassword(item.getString("password"));
                    arraylist_data.add(users);
                }
                listview.setAdapter(new UserAdapter(UserListActivity.this, arraylist_data));
                System.out.println(arraylist_data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            System.out.println();
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        });
        //Adding request to request queue
        AppController.getInstance(getApplicationContext()).addToRequestQueue(strReq);
    }
}
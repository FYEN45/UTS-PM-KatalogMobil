package com.example.katalogkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.katalogkelompok.Config.Config;
import com.example.katalogkelompok.Controller.AppController;

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
            Intent intent = new Intent(UserListActivity.this, UserUpdateActivity.class);
            intent.putExtra("id", arraylist_data.get(position).getId());
            intent.putExtra("name", arraylist_data.get(position).getName());
            intent.putExtra("email", arraylist_data.get(position).getEmail());
            intent.putExtra("phoneNumber", arraylist_data.get(position).getPhoneNumber());
            intent.putExtra("username", arraylist_data.get(position).getUsername());
            intent.putExtra("password", arraylist_data.get(position).getPassword());
            startActivity(intent);
            finish();
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
                    Log.e(TAG, item.toString());
                    Log.e(TAG, item.getString("name"));
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
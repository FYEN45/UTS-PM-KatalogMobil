package com.example.katalogkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listview = findViewById(R.id.listViewUser);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        getData();

    }

    private void showProgressDialog() {
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing()) {
            pDialog.hide();
        }
    }

    private void getData() {
        showProgressDialog();
        StringRequest strReq = new StringRequest(Request.Method.GET, Config.requestUserList,responses -> {
            hideProgressDialog();
            System.out.println();
            try {
                JSONObject response = new JSONObject(responses);
                Toast.makeText(UserListActivity.this, response.getString("error_text"), Toast.LENGTH_SHORT).show();
                JSONObject header = response.getJSONObject("data");
                Iterator<String> iterator = header.keys();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    JSONObject item = (JSONObject) header.get(key);

                    Users users = new Users();
                    users.setId(item.getString("id"));
                    users.setName(item.getString("name"));
                    users.setEmail(item.getString("email"));
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
            hideProgressDialog();
        });
        //Adding request to request queue
        AppController.getInstance(getApplicationContext()).addToRequestQueue(strReq);
    }
}
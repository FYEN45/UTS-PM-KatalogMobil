package com.example.katalogkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.katalogkelompok.Config.Config;
import com.example.katalogkelompok.Controller.AppController;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class UserUpdateActivity extends AppCompatActivity {
    String TAG = LoginActivity.class.getSimpleName();
    TextInputLayout textInputLayoutUpdateName;
    TextInputLayout textInputLayoutUpdateEmail;
    TextInputLayout textInputLayoutUpdatePhoneNumber;
    TextInputLayout textInputLayoutUpdateUsername;
    TextInputLayout textInputLayoutUpdatePassword;
    EditText editTextUpdateName;
    EditText editTextUpdateEmail;
    EditText editTextUpdatePhoneNumber;
    EditText editTextUpdateUsername;
    EditText editTextUpdatePassword;
    Button buttonSave;
    Button buttonDelete;

    String id;
    String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        initViews();
        recieveData();

        buttonSave.setOnClickListener(view -> {
            action = "edit";
            requestUpdateData();
        });

        buttonDelete.setOnClickListener(view -> {
            action = "delete";
            requestUpdateData();
        });
    }

    void recieveData() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        editTextUpdateName.setText(intent.getStringExtra("name"));
        editTextUpdateEmail.setText(intent.getStringExtra("email"));
        editTextUpdatePhoneNumber.setText(intent.getStringExtra("phoneNumber"));
        editTextUpdateUsername.setText(intent.getStringExtra("username"));
        editTextUpdatePassword.setText(intent.getStringExtra("password"));
    }

    void requestUpdateData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.requestUpdateData, responses -> {
            Toast.makeText(UserUpdateActivity.this, responses, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UserUpdateActivity.this, UserListActivity.class);
            startActivity(intent);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
        }, error -> {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
        }) {
            //Data yang dikirim
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("name", String.valueOf(editTextUpdateName.getText()));
                params.put("email", String.valueOf(editTextUpdateEmail.getText()));
                params.put("phoneNumber", String.valueOf(editTextUpdatePhoneNumber.getText()));
                params.put("username", String.valueOf(editTextUpdateUsername.getText()));
                params.put("password", String.valueOf(editTextUpdatePassword.getText()));
                params.put("action", action);
                return params;
            }
        };
        AppController.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    void initViews() {
        textInputLayoutUpdateName = findViewById(R.id.textInputLayoutUpdateName);
        textInputLayoutUpdateEmail = findViewById(R.id.textInputLayoutUpdateEmail);
        textInputLayoutUpdatePhoneNumber = findViewById(R.id.textInputLayoutUpdatePhoneNumber);
        textInputLayoutUpdateUsername = findViewById(R.id.textInputLayoutUpdateUsername);
        textInputLayoutUpdatePassword = findViewById(R.id.textInputLayoutUpdatePassword);
        editTextUpdateName = findViewById(R.id.editTextUpdateName);
        editTextUpdateEmail = findViewById(R.id.editTextUpdateEmail);
        editTextUpdatePhoneNumber = findViewById(R.id.editTextUpdatePhoneNumber);
        editTextUpdateUsername = findViewById(R.id.editTextUpdateUsername);
        editTextUpdatePassword = findViewById(R.id.editTextUpdatePassword);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDelete = findViewById(R.id.buttonDelete);
    }
}
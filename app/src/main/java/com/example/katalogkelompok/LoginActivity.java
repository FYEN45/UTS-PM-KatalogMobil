package com.example.katalogkelompok;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.katalogkelompok.Config.Config;
import com.example.katalogkelompok.Controller.AppController;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    String TAG = LoginActivity.class.getSimpleName();
    TextInputLayout textInputLayoutLoginUsername;
    TextInputLayout textInputLayoutLoginPassword;
    EditText editTextLoginUsername;
    EditText editTextLoginPassword;
    Button buttonLogin;
    TextView textViewRegister;

    Boolean tempBool;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        //Button Login
        buttonLogin.setOnClickListener(view -> {
            showProgressDialog();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.userLoginVerification, responses ->{
                hideProgressDialog();
                if (responses.equals("Login Berhasil!")) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Toast.makeText(LoginActivity.this, responses, Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, responses, Toast.LENGTH_SHORT).show();
                }
            }, error -> {
                VolleyLog.d(TAG, "Error: "+error.getMessage());
                hideProgressDialog();
            })
            {
                //Data yang dikirim
                @Override
                protected Map<String, String> getParams(){
                    Map<String, String> params = new HashMap<>();
                    params.put("username", String.valueOf(editTextLoginUsername.getText()));
                    params.put("password", String.valueOf(editTextLoginPassword.getText()));
                    return params;
                }
            };
            AppController.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        });

        //Textview Intent ke Register
        textViewRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        textInputLayoutLoginUsername = findViewById(R.id.textInputLayoutLoginUsername);
        textInputLayoutLoginPassword = findViewById(R.id.textInputLayoutLoginPassword);
        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewCreateAccount);
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

    private boolean validateUsername() {
        boolean validuser;
        String Username = editTextLoginUsername.getText().toString();
        if (Username.isEmpty()) {
            validuser = false;
            textInputLayoutLoginUsername.setError("Please enter valid username!");
        } else {
            if (Username.length() >= 5) {
                validuser = true;
                textInputLayoutLoginUsername.setError(null);
            } else {
                validuser = false;
                textInputLayoutLoginUsername.setError("Username is to short!");
            }
        }
        return validuser;
    }

    private boolean validatePassword() {
        boolean validpass;
        String Username = editTextLoginPassword.getText().toString();
        if (Username.isEmpty()) {
            validpass = false;
            textInputLayoutLoginPassword.setError("Please enter valid password!");
        } else {
            if (Username.length() >= 5) {
                validpass = true;
                textInputLayoutLoginPassword.setError(null);
            } else {
                validpass = false;
                textInputLayoutLoginPassword.setError("Password is to short!");
            }
        }
        return validpass;
    }
}
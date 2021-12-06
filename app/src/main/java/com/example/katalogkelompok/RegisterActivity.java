package com.example.katalogkelompok;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.katalogkelompok.Config.Config;
import com.example.katalogkelompok.Controller.AppController;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    String TAG = LoginActivity.class.getSimpleName();
    TextInputLayout textInputLayoutRegisterName;
    TextInputLayout textInputLayoutRegisterEmail;
    TextInputLayout textInputLayoutRegisterPhoneNumber;
    TextInputLayout textInputLayoutRegisterUsername;
    TextInputLayout textInputLayoutRegisterPassword;
    EditText editTextRegisterName;
    EditText editTextRegisterEmail;
    EditText editTextRegisterPhoneNumber;
    EditText editTextRegisterUsername;
    EditText editTextRegisterPassword;
    Button buttonRegister;

    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        buttonRegister.setOnClickListener(view -> {
            if (validateName() && validateEmail() && validatePhoneNumber() && validateUsername() && validatePassword()) {
                showProgressDialog();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.userRegister, responses -> {
                    hideProgressDialog();
                    if (responses.equals("Registrasi Berhasil!")) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        Toast.makeText(RegisterActivity.this, responses, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, responses, Toast.LENGTH_SHORT).show();
                    }
                }, error -> {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    hideProgressDialog();
                }) {
                    //Data yang dikirim
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", String.valueOf(editTextRegisterName.getText()));
                        params.put("email", String.valueOf(editTextRegisterEmail.getText()));
                        params.put("phoneNumber", String.valueOf(editTextRegisterPhoneNumber.getText()));
                        params.put("username", String.valueOf(editTextRegisterUsername.getText()));
                        params.put("password", String.valueOf(editTextRegisterPassword.getText()));
                        return params;
                    }
                };
                AppController.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
            }
            else {
                Snackbar.make(buttonRegister, "Gagal Register", Snackbar.LENGTH_LONG).show();
            }
        });
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

    private void initViews() {
        textInputLayoutRegisterName = findViewById(R.id.textInputLayoutRegisterName);
        textInputLayoutRegisterEmail = findViewById(R.id.textInputLayoutRegisterEmail);
        textInputLayoutRegisterPhoneNumber = findViewById(R.id.textInputLayoutRegisterPhone);
        textInputLayoutRegisterUsername = findViewById(R.id.textInputLayoutRegisterUsername);
        textInputLayoutRegisterPassword = findViewById(R.id.textInputLayoutRegisterPassword);

        editTextRegisterName = findViewById(R.id.editTextRegisterName);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterPhoneNumber = findViewById(R.id.editTextRegisterPhone);
        editTextRegisterUsername = findViewById(R.id.editTextRegisterUsername);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);

        buttonRegister = findViewById(R.id.buttonRegister);

        TextView textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(view -> finish());
    }

    private boolean validateName() {
        boolean validname;
        String Name = editTextRegisterName.getText().toString();

        if (Name.isEmpty()) {
            validname = false;
            textInputLayoutRegisterName.setError("Please enter valid Name!");
        } else {
            if (Name.length() >= 3) {
                validname = true;
                textInputLayoutRegisterName.setError(null);
            } else {
                validname = false;
                textInputLayoutRegisterName.setError("Name is too short!");
            }
        }
        return validname;
    }

    private boolean validateEmail() {
        boolean validemail;

        String Email = editTextRegisterEmail.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            validemail = false;
            textInputLayoutRegisterEmail.setError("Please enter valid email");
        } else {
            validemail = true;
            textInputLayoutRegisterEmail.setError(null);
        }
        return validemail;
    }

    private boolean validatePhoneNumber() {
        boolean validphone;
        String PhoneNumber = editTextRegisterPhoneNumber.getText().toString();

        if (PhoneNumber.isEmpty()) {
            validphone = false;
            textInputLayoutRegisterPhoneNumber.setError("Please enter valid phone number!");
        } else {
            if (PhoneNumber.length() >= 6 && PhoneNumber.length() <= 13) {
                validphone = true;
                textInputLayoutRegisterPhoneNumber.setError(null);
            } else {
                validphone = false;
                textInputLayoutRegisterPhoneNumber.setError("Phone number is invalid");
            }
        }
        return validphone;
    }

    private boolean validateUsername() {
        boolean validuser;
        String UserName = editTextRegisterUsername.getText().toString();

        if (UserName.isEmpty()) {
            validuser = false;
            textInputLayoutRegisterUsername.setError("Please enter valid username!");
        } else {
            if (UserName.length() >= 5) {
                validuser = true;
                textInputLayoutRegisterUsername.setError(null);
            } else {
                validuser = false;
                textInputLayoutRegisterUsername.setError("Username is too short!");
            }
        }
        return validuser;
    }

    private boolean validatePassword() {
        boolean validpass;
        String Password = editTextRegisterPassword.getText().toString();

        if (Password.isEmpty()) {
            validpass = false;
            textInputLayoutRegisterPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() >= 5) {
                validpass = true;
                textInputLayoutRegisterPassword.setError(null);
            } else {
                validpass = false;
                textInputLayoutRegisterPassword.setError("Password is too short!");
            }
        }
        return validpass;
    }
}
package com.tecsup.martinchavez.mynotepad.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tecsup.martinchavez.mynotepad.R;
import com.tecsup.martinchavez.mynotepad.repository.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText fullnameInput;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    private TextInputEditText passwordRepeatInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullnameInput = (TextInputEditText) findViewById(R.id.registerFullnameText);
        emailInput = (TextInputEditText) findViewById(R.id.registerEmailText);
        passwordInput = (TextInputEditText) findViewById(R.id.registerPasswordText);
        passwordRepeatInput = (TextInputEditText) findViewById(R.id.registerRepeatPasswordText);
    }

    public void callRegister(View view){
        String fullname= fullnameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String passwordReapeat= passwordRepeatInput.getText().toString();
        if(fullname.isEmpty() || email.isEmpty() || password.isEmpty() || passwordReapeat.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.equals(passwordReapeat)) {
            UserRepository.create(fullname, email, password);
            startActivity(new Intent(this, MainActivity.class));
        }
        else{
            Toast.makeText(this, "Password and password repeat fields must be equals", Toast.LENGTH_SHORT).show();
            return;
        }
        finish();
    }
}

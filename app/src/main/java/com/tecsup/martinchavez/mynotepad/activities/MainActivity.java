package com.tecsup.martinchavez.mynotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tecsup.martinchavez.mynotepad.R;
import com.tecsup.martinchavez.mynotepad.models.User;
import com.tecsup.martinchavez.mynotepad.repository.UserRepository;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    public static final String SHARED_PREFERENCE_NAME = "MyNotePad";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailInput = (TextInputEditText) findViewById(R.id.loginEmail);
        passwordInput = (TextInputEditText) findViewById(R.id.loginPassword);
        sharedPreferences = this.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", null);
        if(email != null){
            emailInput.setText(email);
            passwordInput.requestFocus();
        }
        if(sharedPreferences.getBoolean("islogged", false)){
            // Go to Dashboard
            goNotes();
        }
    }

    public void callLogin(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = UserRepository.findByEmail(email,password);
        if (user==null){
            Toast.makeText(this, "Email or password invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Welcome " + user.getFullname(), Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean success = editor
                .putString("email", user.getEmail())
                .putBoolean("islogged", true)
                .commit();
        goNotes();
    }
    
    public void goRegister(View view){
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }
    private void goNotes(){
        startActivity(new Intent(this, NotesActivity.class));
        finish();
    }
}

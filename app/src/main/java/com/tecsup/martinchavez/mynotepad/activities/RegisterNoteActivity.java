package com.tecsup.martinchavez.mynotepad.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tecsup.martinchavez.mynotepad.R;
import com.tecsup.martinchavez.mynotepad.repository.NoteRepository;

public class RegisterNoteActivity extends AppCompatActivity {

    private TextInputEditText titleInput;
    private TextInputEditText typeInput;
    private TextInputEditText contentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_note);

        titleInput = (TextInputEditText) findViewById(R.id.inputTitle);
        typeInput = (TextInputEditText) findViewById(R.id.inputType);
        contentInput = (TextInputEditText) findViewById(R.id.inputContent);
    }
    public void saveNote(View view){
        String title = titleInput.getText().toString();
        String type = typeInput.getText().toString();
        String content = contentInput.getText().toString();
        if(title.isEmpty() || type.isEmpty() || content.isEmpty()){
            Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
            return;
        }
        NoteRepository.create(title,type,content);
        startActivity(new Intent(this, NotesActivity.class));
        finish();
    }
}

package com.tecsup.martinchavez.mynotepad.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tecsup.martinchavez.mynotepad.R;
import com.tecsup.martinchavez.mynotepad.adapters.NoteAdapter;
import com.tecsup.martinchavez.mynotepad.models.Note;
import com.tecsup.martinchavez.mynotepad.repository.NoteRepository;

import java.util.List;

public class NotesActivity extends AppCompatActivity {
    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesList = (RecyclerView) findViewById(R.id.note_list);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        List<Note> notes = NoteRepository.list();
        notesList.setAdapter(new NoteAdapter(notes));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NoteAdapter adapter = (NoteAdapter) notesList.getAdapter();

        List<Note> notes = NoteRepository.list();
        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();

    }

    public void callRegisterNote(View view){
        startActivity(new Intent(this,RegisterNoteActivity.class));
    }
}

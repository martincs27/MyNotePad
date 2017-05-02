package com.tecsup.martinchavez.mynotepad.adapters;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecsup.martinchavez.mynotepad.R;
import com.tecsup.martinchavez.mynotepad.models.Note;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Alumno on 2/5/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView type;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            type = (TextView) itemView.findViewById(R.id.type_text);
            content = (TextView) itemView.findViewById(R.id.content_text);
        }
    }
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_note, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note note = this.notes.get(position);
        viewHolder.title.setText(note.getTitle());
        viewHolder.type.setText(note.getType());
        viewHolder.content.setText(note.getContent());

    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}

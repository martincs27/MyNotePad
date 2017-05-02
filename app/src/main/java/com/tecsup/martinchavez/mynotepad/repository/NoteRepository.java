package com.tecsup.martinchavez.mynotepad.repository;

import com.orm.SugarRecord;
import com.tecsup.martinchavez.mynotepad.models.Note;

import java.util.List;

/**
 * Created by Alumno on 2/5/2017.
 */

public class NoteRepository {

    public static List<Note> list(){
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static Note read(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        return note;
    }

    public static void create(String title, String type, String content){
        Note note = new Note(title, type, content);
        note.save();
    }

    public static void update(String title, String type, String content, Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.setTitle(title);
        note.setType(type);
        note.setContent(content);
        note.save();
    }

    public static void delete(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        note.delete();
    }
}


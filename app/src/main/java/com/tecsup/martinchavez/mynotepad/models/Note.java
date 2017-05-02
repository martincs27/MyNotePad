package com.tecsup.martinchavez.mynotepad.models;

import com.orm.SugarRecord;

/**
 * Created by Alumno on 2/5/2017.
 */

public class Note extends SugarRecord<Note> {
    private Long id;
    private String title;
    private String type;
    private String content;

    public Note() {
    }

    public Note(String title, String type, String content) {
        this.title = title;
        this.type = type;
        this.content = content;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

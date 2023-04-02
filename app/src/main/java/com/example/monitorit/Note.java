package com.example.monitorit;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Date;

public class Note {

    public static ArrayList<Note> noteArrayList = new ArrayList<>();
    private int id;
    private String name;
    private String description;
    private Date deleted;

    public Note(int id, String name, String description, Date deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }

    public Note(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        deleted = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
}

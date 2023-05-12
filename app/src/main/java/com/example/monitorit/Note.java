package com.example.monitorit;

import java.util.ArrayList;
import java.util.Date;

public class Note {

    private int id;
    private String title;
    private String description;
    private Date deleted;


    // ArrayList to store all the notes
    public static ArrayList<Note> noteArrayList = new ArrayList<>();

    // Extra key for passing note data when editing
    public static String NOTE_EDIT_EXTRA ="noteEdit";
    public Note(int id, String title, String description, Date deleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
    }

    public Note(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        deleted = null;
    }

    // Method to get a note for a given athlete note ID
    public static Note getNoteForID(int passedNoteID) {
        for(Note note: noteArrayList) {
            if(note.getId() == passedNoteID){
                return note;
            }

        }
        return null;
    }
    // Method to get a list of non-deleted athlete's notes
    public static ArrayList<Note> nonDeletedNote() {
        ArrayList<Note> nonDeleted = new ArrayList<>();
        for (Note note : noteArrayList) {
            if (note.getDeleted() == null) {
                nonDeleted.add(note);
            }
        }
        return nonDeleted;
     }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

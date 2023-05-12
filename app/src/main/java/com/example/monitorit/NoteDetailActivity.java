package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class NoteDetailActivity extends AppCompatActivity {


    private EditText titleEdittext, descEditText;
    private Button deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        initWidgets();
        checkForEditNote();
    }
private Note selectedNote;
    private void checkForEditNote() {
        Intent previousIntent = getIntent();
        int passedNoteID = previousIntent.getIntExtra(Note.NOTE_EDIT_EXTRA, -1);
        selectedNote = Note.getNoteForID(passedNoteID);

        if(selectedNote != null) {
            // If editing an existing note, populate the EditText fields with note details
            titleEdittext.setText(selectedNote.getTitle());
            descEditText.setText(selectedNote.getDescription());
        } else {
            // If creating a new note, hide the delete button
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    private void initWidgets() {
        titleEdittext = findViewById(R.id.titleEditText);
        descEditText =findViewById(R.id.descriptionEditText);
        deleteButton = findViewById(R.id.deleteAthlete);

    }



    public void SaveNote(View view) {

        // Get the title and description from the EditText fields
        String title = String.valueOf(titleEdittext.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedNote == null) {
            // Creating a new note
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, title, desc);
            Note.noteArrayList.add(newNote);
        } else {
            // Editing an existing note
            selectedNote.setTitle(title);
            selectedNote.setDescription(desc);
        }
        finish(); // Finish the activity and return to the previous screen
    }

    public void DeleteNote(View view) {
        // Set the deleted date of the selected note
        selectedNote.setDeleted(new Date());
        finish(); // Finish the activity and return to the previous screen
    }
}
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
            titleEdittext.setText(selectedNote.getTitle());
            descEditText.setText(selectedNote.getDescription());
        } else {
            deleteButton.setVisibility(View.INVISIBLE);
        }
    }

    private void initWidgets() {
        titleEdittext = findViewById(R.id.titleEditText);
        descEditText =findViewById(R.id.descriptionEditText);
        deleteButton = findViewById(R.id.deleteAthlete);

    }



    public void SaveNote(View view) {


        String title = String.valueOf(titleEdittext.getText());
        String desc = String.valueOf(descEditText.getText());

        if(selectedNote == null) {
            int id = Note.noteArrayList.size();
            Note newNote = new Note(id, title, desc);
            Note.noteArrayList.add(newNote);
        } else {
            selectedNote.setTitle(title);
            selectedNote.setDescription(desc);
        }
        finish();
    }

    public void DeleteNote(View view) {
        selectedNote.setDeleted(new Date());
        finish();
    }
}
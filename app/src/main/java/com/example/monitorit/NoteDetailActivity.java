package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NoteDetailActivity extends AppCompatActivity {


    private EditText titleEdittext, descEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        initWidgets();
    }

    private void initWidgets() {
        titleEdittext = findViewById(R.id.titleEditText);
        descEditText =findViewById(R.id.descriptionEditText);

    }

    public void SaveNote(View view) {

        String title = String.valueOf(titleEdittext.getText());
        String desc = String.valueOf(descEditText.getText());

        int id = Note.noteArrayList.size();
        Note newNote = new Note(id,title,desc);
        Note.noteArrayList.add(newNote);
        finish();
    }
}
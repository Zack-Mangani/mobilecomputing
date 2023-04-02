package com.example.monitorit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AthleteDetailActivity extends AppCompatActivity {
    private EditText descriptionEditText,athleteNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_detail);
        initWidgets();
    }


    private void initWidgets(){
        athleteNameEditText  = findViewById(R.id.athleteNameEditText);
        descriptionEditText =findViewById(R.id.descriptionEditText);


    }
    public void saveAthlete(View view) {
         String athlete = String.valueOf(athleteNameEditText.getText());
         String description = String.valueOf(descriptionEditText.getText());

         int id = Note.noteArrayList.size();
         Note newNote = new Note(id,athlete,description);
         Note.noteArrayList.add(newNote);
         finish();
    }
}
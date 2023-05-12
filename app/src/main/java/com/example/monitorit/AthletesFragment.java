package com.example.monitorit;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class AthletesFragment extends Fragment {

    private ListView noteListView;
    private Button newAthleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_athletes, container, false);
        initViews(view);

        setNotesAdapter();
        setListeners();
        setOnClickListener();
        return view;
    }


    private void initViews(View view) {
        noteListView = view.findViewById(R.id.athletesListView);
        newAthleteButton = view.findViewById(R.id.newAthlete);
    }

    private void setNotesAdapter() {
        // Create and set the adapter for the noteListView using the nonDeletedNote() method of the Note class
        NoteAdapter noteAdapter = new NoteAdapter(getContext(), Note.nonDeletedNote());
        noteListView.setAdapter(noteAdapter);
    }
    private void setOnClickListener(){
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click on a note item in the list
                Note selectedNote = (Note) noteListView.getItemAtPosition(position);
                Intent editNoteIntent = new Intent(getContext(),NoteDetailActivity.class);
                editNoteIntent.putExtra(Note.NOTE_EDIT_EXTRA,selectedNote.getId());
                startActivity(editNoteIntent);
            }
        });
    }


    private void setListeners() {
        // Set a click listener for the newAthleteButton
        newAthleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click on the newAthleteButton
                newAthlete();
            }
        });
    }

    public void newAthlete() {
        // Start the NoteDetailActivity to create a new note
        Intent newNoteIntent = new Intent(getActivity(), NoteDetailActivity.class);
        startActivityForResult(newNoteIntent, 1);
    }

    @Override
    public void onResume() {
        // Update the notes adapter when the fragment resumes
        super.onResume();
        setNotesAdapter();
    }
}

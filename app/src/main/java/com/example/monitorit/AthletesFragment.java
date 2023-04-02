package com.example.monitorit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View view = inflater.inflate(R.layout.fragment_athletes, container, false);
        initViews(view);
        setNotesAdapter();
        setListeners();
        return view;
    }

    private void initViews(View view) {
        noteListView = view.findViewById(R.id.athletesListView);
        newAthleteButton = view.findViewById(R.id.newAthlete);
    }

    private void setNotesAdapter() {
        NoteAdapter noteAdapter = new NoteAdapter(getContext(), Note.noteArrayList);
        noteListView.setAdapter(noteAdapter);
    }

    private void setListeners() {
        newAthleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAthlete();
            }
        });
    }

    public void newAthlete() {
        Intent newNoteIntent = new Intent(getActivity(), NoteDetailActivity.class);
        startActivityForResult(newNoteIntent, 1);
    }

}

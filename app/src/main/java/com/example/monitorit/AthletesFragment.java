package com.example.monitorit;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


public class AthletesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    public AthletesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
private ListView noteListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_athletes);
        initWidgets();
        setNotesAdapter();
    }

    public void setNotesAdapter() {
        NoteAdapter noteAdapter = new NoteAdapter(getActivity().getApplicationContext(), Note.noteArrayList);
        noteListView.setAdapter(noteAdapter);
    }


    private void initWidgets() {
        noteListView = view.findViewById(R.id.athletesListView);
    }


    private void setContentView(int fragment_athletes) {
    }
    private View view;

    private Button newAthlete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_athletes, container, false);
        newAthlete = view.findViewById(R.id.newAthleteCheck);
        newAthlete.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {

                newAthleteImp();
            }
        });


        return view;
    }

    public void newAthleteImp() {
        Intent newNoteIntent = new Intent(getContext(), AthleteDetailActivity.class);
        startActivity(newNoteIntent);
    }



}
package com.example.monitorit;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes) {
        super(context, 0, notes);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.athletenote_cell, parent, false);
        }
            TextView athlete = convertView.findViewById(R.id.cellAthlete);
            TextView desc = convertView.findViewById(R.id.cellDesc);

            athlete.setText(note.getName());
            desc.setText(note.getDescription());


            return convertView;
        }
    }


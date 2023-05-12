package com.example.monitorit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, List<Note> notes){
        super(context,0,notes);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the Note object for the current position
        Note note  = getItem(position);
        // Inflate the view if it is not already created
                if(convertView == null)
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_cell,parent,false);


        // Get references to the views in the note_cell layout
        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView desc = convertView.findViewById(R.id.cellDesc);

        // Set the title and description of the Note object to the respective views
        title.setText(note.getTitle());
        desc.setText(note.getDescription());

        return convertView;


    }
}

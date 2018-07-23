package com.example.android.tourguidezagreb;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EntryAdapter extends ArrayAdapter<Entry> {

    public EntryAdapter(Activity context, ArrayList<Entry> entries) {
        super(context, 0, entries);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.entry_item, parent,
                    false);
        }

        Entry currentEntry = getItem(position);

        TextView entryNameTextView = listItemView.findViewById(R.id.entry_name);
        entryNameTextView.setText(currentEntry.getmEntryNameId());

        ImageView entryImageView = listItemView.findViewById(R.id.entry_image);
        entryImageView.setImageResource(currentEntry.getmEntryIconId());

        return listItemView;
    }

}

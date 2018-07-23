package com.example.android.tourguidezagreb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class NightlifeFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        final ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.string.tvornica, R.drawable.tvornica,
                R.drawable.ic_tvornica, R.string.tvornica_info));
        entries.add(new Entry(R.string.beertija, R.drawable.beertija, R.drawable.ic_beertija,
                R.string.beertija_info));
        entries.add(new Entry(R.string.vintage, R.drawable.vintage,
                R.drawable.ic_vintage, R.string.vintage_info));

        EntryAdapter adapter = new EntryAdapter(getActivity(), entries);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent details = new Intent(getActivity(), DetailActivity.class);

                details.putExtra(getResources().getString(R.string.entries), entries.get(position));
                startActivity(details);
            }
        });
        return rootView;
    }
}

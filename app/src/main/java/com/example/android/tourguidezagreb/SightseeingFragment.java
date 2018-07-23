package com.example.android.tourguidezagreb;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SightseeingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        final ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.string.gric_tunnel, R.drawable.gric_tunnel,
                R.drawable.ic_gric_tunnel, R.string.gric_tunnel_info));
        entries.add(new Entry(R.string.lotrscak_tower, R.drawable.lotrscak_tower, R.drawable.ic_lotrscak_tower,
                R.string.lotrscak_tower_info));
        entries.add(new Entry(R.string.broken_museum, R.drawable.broken_museum,
                R.drawable.ic_broken_museum, R.string.broken_museum_info));

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


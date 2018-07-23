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

public class CityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        final ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.string.main_square, R.drawable.zagreb_square,
                R.drawable.ic_zagreb_square, R.string.main_square_info));
        entries.add(new Entry(R.string.city_hall, R.drawable.city_hall,
                R.drawable.ic_city_hall, R.string.city_hall_info));
        entries.add(new Entry(R.string.st_mark_church, R.drawable.st_marks_church,
                R.drawable.ic_st_marks_church, R.string.st_mark_church_info));
        entries.add(new Entry(R.string.zrinjevac, R.drawable.zrinjevac,
                R.drawable.ic_zrinjevac, R.string.zrinjevac_info));
        entries.add(new Entry(R.string.cathedral, R.drawable.cathedral,
                R.drawable.ic_cathedral, R.string.cathedral_info));
        entries.add(new Entry(R.string.ribnjak, R.drawable.ribnjak,
                R.drawable.ic_ribnjak, R.string.ribnjak_info));

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

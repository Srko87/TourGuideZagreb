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

public class FoodFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        final ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(R.string.la_struk, R.drawable.la_struk, R.drawable.ic_la_struk,
                R.string.la_struk_info));
        entries.add(new Entry(R.string.dubravkin_put, R.drawable.dubravkin_put, R.drawable.ic_dubravkin_put,
                R.string.dubravkin_put_info));
        entries.add(new Entry(R.string.bistro_vjestica, R.drawable.bistro_vjestica,
                R.drawable.ic_bistro_vjestica, R.string.bistro_vjestica_info));
        entries.add(new Entry(R.string.sherry_wine_bar, R.drawable.sherry_wine_bar,
                R.drawable.ic_sherry_wine_bar, R.string.sherry_wine_bar_info));

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

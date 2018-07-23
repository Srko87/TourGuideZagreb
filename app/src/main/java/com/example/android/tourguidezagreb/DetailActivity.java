package com.example.android.tourguidezagreb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent details = getIntent();
        Entry currentEntry = details.getParcelableExtra(getResources().getString(R.string.entries));

        int entryImage = currentEntry.getmEntryPicutreId();
        int entryName = currentEntry.getmEntryNameId();
        int entryInfo = currentEntry.getmEntryInfoId();

        ImageView entryImageView = findViewById(R.id.entry_image);
        entryImageView.setImageResource(entryImage);

        TextView entryNameTextView = findViewById(R.id.entry_name);
        entryNameTextView.setText(entryName);

        TextView entryInfoTextView = findViewById(R.id.entry_info);
        entryInfoTextView.setText(entryInfo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}

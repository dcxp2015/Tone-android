package com.dcxp.tone.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dcxp.tone.Phrase;
import com.dcxp.tone.R;
import com.dcxp.tone.RVPhraseAdapter;

import java.util.ArrayList;
import java.util.List;


public class SelectWorkoutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_workout);

        final String[] workouts = new String[25];

        for(int i = 0; i < workouts.length; i++) {
            workouts[i] = "workout " + i;
        }

        ListView listView = (ListView) findViewById(R.id.lv_workouts);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, workouts));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectWorkoutActivity.this, PlaylistActivity.class);
                intent.putExtra("workout", workouts[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_workout, menu);
        return true;
    }
}

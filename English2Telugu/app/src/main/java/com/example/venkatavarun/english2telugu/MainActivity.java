package com.example.venkatavarun.english2telugu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.venkatavarun.english2telugu.Actor.Actor;
import com.example.venkatavarun.english2telugu.adapters.ListProductAdapter;
import com.example.venkatavarun.english2telugu.widget.IndexableListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IndexableListView listView;
    private Context mContext;
    private ListProductAdapter adapter;
    private List<Actor> quotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("sai", "in on create");
        this.listView = (IndexableListView) findViewById(R.id.listView);
        Log.d("sai", "in on create");


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.openDatabase();
        Log.d("sai", "in open");
        quotes = databaseAccess.getQuotes();
        databaseAccess.closeDatabase();
        adapter = new ListProductAdapter(this, quotes);
        Log.d("sai", "in on workig");
        this.listView.setAdapter(adapter);
        listView.setFastScrollEnabled(true);


 /*ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);*/

        //  ListProductAdapter adapter = new ListProductAdapter(this, android.R.layout.simple_list_item_1, quotes);
     /*   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {


               *//* String data=(String)adapter.getItemAtPosition(position);
                text = (TextView) findViewById(R.id.textmeaning1);
                text.setText(data);
*//*
                Intent i = new Intent(MainActivity.this, SingleItemView.class);

                startActivity(i);

            }
        });*/
    }

}

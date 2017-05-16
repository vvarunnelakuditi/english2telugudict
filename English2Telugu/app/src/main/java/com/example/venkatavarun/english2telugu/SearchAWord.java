package com.example.venkatavarun.english2telugu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;


import com.example.venkatavarun.english2telugu.Actor.Actor;
import com.example.venkatavarun.english2telugu.adapters.ListProductAdapter1;
import com.example.venkatavarun.english2telugu.adapters.SingleItemView;
import com.example.venkatavarun.english2telugu.widget.IndexableListView;

import java.util.List;
import java.util.Locale;


public class SearchAWord extends AppCompatActivity {

    private IndexableListView listView;
    EditText editsearch;
    ListProductAdapter1 adapter;


    private Context mContext;

    private List<Actor> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        // Locate the EditText in listview_main.xml
        this.editsearch = (EditText) findViewById(R.id.search1);
        this.listView = (IndexableListView) findViewById(R.id.listview1);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.openDatabase();
        quotes = databaseAccess.getQuotes();


        databaseAccess.closeDatabase();

        adapter = new ListProductAdapter1(this,quotes);
        Log.d("sai", "iiiiiiiiiiiiiin on create");
        this.listView.setAdapter(adapter);
        listView.setFastScrollEnabled(true);

        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {

                Intent i=new Intent(SearchAWord.this,SingleItemView.class);
                startActivity(i);

            }
        });


    }



}

package com.example.venkatavarun.english2telugu.adapters;

/**
 * Created by venkatavarun on 15-05-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.venkatavarun.english2telugu.Actor.Actor;
import com.example.venkatavarun.english2telugu.R;

import java.util.List;


public class ListProductAdapter extends BaseAdapter implements SectionIndexer {

    private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Context context;
    List<Actor> mProductList;




    public ListProductAdapter(Context mContext, List<Actor> mProductList) {
        this.context = mContext;
        this.mProductList = mProductList;


    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.item_listview, null);
        TextView tvName = (TextView) v.findViewById(R.id.tv_product_name);
        // TextView tvName1 = (TextView)v.findViewById(R.id.tv_product_name1);


        tvName.setText(mProductList.get(position).getName());
        //  tvName1.setText(mProductList.get(position).getMeaning());

        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data rank
                // Pass all data country
                intent.putExtra("country", (mProductList.get(position).getName()));
                // Pass all data population
                intent.putExtra("population", (mProductList.get(position).getMeaning()));
                // Pass all data flag
                // Start SingleItemView Class
                context.startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public Object[] getSections() {
        String[] sections = new String[mSections.length()];
        for (int i = 0; i < mSections.length(); i++)
            sections[i] = String.valueOf(mSections.charAt(i));
        return sections;
    }

    @Override
    public int getPositionForSection(int section) {
        // If there is no item for current section, previous section will be selected
       /* for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(mProductList.get(j).getName().charAt(0)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(mProductList.get(j).getName().charAt(0)),
                            String.valueOf(mSections.charAt(i))))
                        return j;
                }
            }
        }
        return 0;*/
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(mProductList.get(j).getName().charAt(0)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(mProductList.get(j).getName().charAt(0)),
                            String.valueOf(mSections.charAt(i))))

                        return j;
                }
            }
        }
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}



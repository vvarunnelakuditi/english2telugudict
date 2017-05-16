package com.example.venkatavarun.english2telugu.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;


import com.example.venkatavarun.english2telugu.Actor.Actor;
import com.example.venkatavarun.english2telugu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListProductAdapter1 extends BaseAdapter implements SectionIndexer {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Actor> worldpopulationlist;
    private ArrayList<Actor> arraylist;
    private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public ListProductAdapter1(Context context, List<Actor> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Actor>();
        this.arraylist.addAll(worldpopulationlist);
    }

    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public Actor getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.rank);
            // holder.country = (TextView) view.findViewById(R.id.country);
            // holder.population = (TextView) view.findViewById(R.id.population);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.rank.setText(worldpopulationlist.get(position).getName());
//        holder.country.setText(worldpopulationlist.get(position).getMeaning());

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                // Pass all data country
                intent.putExtra("country",(worldpopulationlist.get(position).getName()));
                // Pass all data population
                intent.putExtra("population",(worldpopulationlist.get(position).getMeaning()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        }
        else
        {
            for (Actor wp : arraylist)
            {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
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
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(worldpopulationlist.get(j).getName().charAt(0)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(worldpopulationlist.get(j).getName().charAt(0)),
                            String.valueOf(mSections.charAt(i))))
                        return j;
                }
            }
        }
        return 0;
       /* for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(worldpopulationlist.get(j).getName().charAt(0)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(worldpopulationlist.get(j).getName().charAt(0)),
                            String.valueOf(mSections.charAt(i))))

                        return j;
                }
            }
        }
        return 0;*/
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
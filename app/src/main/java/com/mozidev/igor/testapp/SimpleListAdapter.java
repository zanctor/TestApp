package com.mozidev.igor.testapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by igor on 18.08.15.
 */
public class SimpleListAdapter extends ArrayAdapter<String> {

    List<String> mItems;

    public SimpleListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mItems = objects;
    }

    @Override
    public String getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1 ,parent, false);
        }
        TextView tv = (TextView)v.findViewById(android.R.id.text1);
        tv.setText(getItem(position));
        return v;
    }

    @Override
    public int getPosition(String item) {
        return mItems.indexOf(item);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }
}

package com.mozidev.igor.testapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.List;


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
        ViewHolder vh = new ViewHolder();
        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_country ,parent, false);
            vh.tv = (TextView)v.findViewById(android.R.id.text1);
            v.setTag(vh);
        }
        vh = (ViewHolder)v.getTag();
        vh.tv.setText(getItem(position));
        return v;
    }

    @Override
    public int getPosition(String item) {
        return mItems.indexOf(item);
    }

    public void removeItem(int position){
        mItems.remove(getPosition(getItem(position)));
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    static class ViewHolder {
        TextView tv;
    }
}





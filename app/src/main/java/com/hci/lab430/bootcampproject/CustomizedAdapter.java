package com.hci.lab430.bootcampproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lab430 on 15/7/29.
 */
public class CustomizedAdapter extends ArrayAdapter<CalendarTime>{

    private final static int layoutResID = R.layout.list_simpleitem1;

    public CustomizedAdapter(Context context, ArrayList<CalendarTime> arrayList) {
        super(context, layoutResID, arrayList);

    }

    private static class ViewHolder {
        public TextView weekDay_textView;
        public TextView date_textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        CalendarTime calTime = getItem(position);
        ViewHolder viewHolder = null; // view lookup cache stored in tag
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(layoutResID, parent, false);
            viewHolder.weekDay_textView = (TextView) convertView.findViewById(R.id.textView1);
            viewHolder.date_textView = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.weekDay_textView.setText(calTime.weekDay);
        viewHolder.date_textView.setText(calTime.date);
        // Return the completed view to render on screen
        return convertView;

    }
}

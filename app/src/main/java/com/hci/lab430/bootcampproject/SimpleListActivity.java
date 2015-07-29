package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lab430 on 15/7/28.
 */
public class SimpleListActivity extends Activity {


    private String[] itemKeys = new String[]{"item","subitem"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView)findViewById(R.id.listView);
        setOneItemList(listView);
    }

    private void setOneItemList(ListView listView) {
        listView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                TestTimeData.weekDayStr));
    }

    private void setTwoItemList(ListView listView) {
        ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
        for(int i = 0;i < TestTimeData.weekDayStr.length;i++) {
            HashMap<String, String> listItem = new HashMap<String, String>();
            listItem.put(itemKeys[0],TestTimeData.weekDayStr[i]);
            listItem.put(itemKeys[1],TestTimeData.dateStr[i]);
            items.add(listItem);
        }

        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                items,
                android.R.layout.simple_list_item_2,
                new String[]{itemKeys[0],itemKeys[1]},
                new int[]{android.R.id.text1,android.R.id.text2}
        );
        listView.setAdapter(simpleAdapter);
    }


}

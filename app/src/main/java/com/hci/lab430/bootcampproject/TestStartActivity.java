package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lab430 on 15/7/29.
 */
public class TestStartActivity extends Activity {
    private final static String debug_tag = "TestStartActivity";
    private String[] itemKeys = new String[]{"item","subitem"};
    private ArrayList<HashMap<String, String>> items;

    private int listStructureDepth = 1;
    private final static String listStructureDepth_Key = "listStructureDepth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ListView listView = (ListView)findViewById(R.id.listView);

        Intent intentPassed = getIntent();
        if(intentPassed != null) {
            listStructureDepth = intentPassed.getIntExtra(listStructureDepth_Key, 1);
        }

        if(listStructureDepth == 1) {
            setData(TestTimeData.weekDayStr, TestTimeData.dateStr);
        }
        else if(listStructureDepth == 2) {
            setData(TestScheduleData.eventStr, TestScheduleData.intervalStr);
        }

        setTwoItemList(listView);
    }

    private void setData(String[] mainStrs, String[] secStrs) {
        items = new ArrayList<HashMap<String, String>>();
        for(int i = 0;i < mainStrs.length;i++) {
            HashMap<String, String> listItem = new HashMap<String, String>();
            listItem.put(itemKeys[0],mainStrs[i]);
            listItem.put(itemKeys[1],secStrs[i]);
            items.add(listItem);
        }
    }

    private void setTwoItemList(ListView listView) {

        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                items,
                android.R.layout.simple_list_item_2,
                new String[]{itemKeys[0],itemKeys[1]},
                new int[]{android.R.id.text1,android.R.id.text2}
        );

        listView.setAdapter(simpleAdapter);
        if(listStructureDepth == 1) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long arg3) {
                    Intent intent = new Intent();
                    intent.putExtra(listStructureDepth_Key, listStructureDepth + 1);
                    intent.setClass(TestStartActivity.this, TestStartActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}

package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lab430 on 15/7/29.
 */
public class TestMyAdapterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<CalendarTime> calendarTimes = new ArrayList<>();
        for(int i = 0;i < TestTimeData.weekDayStr.length;i++) {
            CalendarTime calTime = new CalendarTime(TestTimeData.weekDayStr[i],TestTimeData.dateStr[i]);
            calendarTimes.add(calTime);
        }

        CustomizedAdapter myAdapter = new CustomizedAdapter(this, calendarTimes);

        setContentView(R.layout.activity_listview);
        ((ListView)findViewById(R.id.listView)).setAdapter(myAdapter);

    }
}

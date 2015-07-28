package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by lab430 on 15/7/28.
 */
public class TestUIActivity extends Activity implements Button.OnClickListener{

    private TextView showBtnClickedTimesTextView;
    private TextView showOptionSelected;
    private Button simpleBtn;
    private RadioGroup radioGroup;
    private Spinner simpleSpinner;
    private String[] spinnerItems = new String[]{
            "包子",
            "Lucien",
            "王權"
    };

    private String[] spinnerResp = new String[]{
            "Unity超強",
            "前端設計超強",
            "PH低XD"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();

    }

    private void setupUI() {
        setContentView(R.layout.activity_testui);
        showBtnClickedTimesTextView = (TextView)findViewById(R.id.showInfo);
        simpleBtn = (Button)findViewById(R.id.simpleBtn);
        radioGroup = (RadioGroup)findViewById(R.id.simpleRadioGroup);
        showOptionSelected = (TextView)findViewById(R.id.optionSelected);
        simpleSpinner = (Spinner)findViewById(R.id.simpleSpinner);
        simpleSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems));
        setListeners();
        showOptionSelected.setText("empty2");
    }

    private void setListeners() {
        simpleBtn.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() { //anonymous class
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                RadioButton radioButton = (RadioButton) findViewById(checkedID);
                showOptionSelected.setText(radioButton.getText());
            }

        });
        simpleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long arg3) {
                showOptionSelected.setText(spinnerResp[pos]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    int btnPressedTimes = 0;

    @Override
    public void onClick(View view) {
        btnPressedTimes++;
        showBtnClickedTimesTextView.setText("button pressed:" + btnPressedTimes);
    }
}

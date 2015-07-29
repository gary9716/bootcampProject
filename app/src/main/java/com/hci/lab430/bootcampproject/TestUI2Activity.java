package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lab430 on 15/7/29.
 */
public class TestUI2Activity extends Activity{

    Button simpleButton;
    TextView infoTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();

    }

    private void setupView() {
        setContentView(R.layout.activity_test1);
        simpleButton = (Button)findViewById(R.id.button3);
        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("testButton","Btn is clicked");
            }
        });

    }

}

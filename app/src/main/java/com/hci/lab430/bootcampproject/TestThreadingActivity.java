package com.hci.lab430.bootcampproject;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;


/**
 * Created by lab430 on 15/7/29.
 */
public class TestThreadingActivity extends Activity implements View.OnClickListener{

    Button simpleBtn;
    Button loadImgBtn;
    TextView txtView;
    ImageView imgView;
    Handler uiHandler;

    final String googleLogoURL = "http://www.google.com.tw/images/srpr/logo11w.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();

    }

    void setupView() {
        setContentView(R.layout.activity_testthreading);
        simpleBtn = (Button)findViewById(R.id.button);
        loadImgBtn = (Button)findViewById(R.id.button2);
        txtView = (TextView)findViewById(R.id.textView);
        imgView = (ImageView)findViewById(R.id.imageView);

        uiHandler = new Handler(getMainLooper());

        setListeners();

    }

    int numPressed = 0;

    void setListeners() {
        simpleBtn.setOnClickListener(this);
        loadImgBtn.setOnClickListener(this);
    }


    private Drawable loadImageFromURL(String url){
        try{
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable draw = Drawable.createFromStream(is, "src");
            return draw;
        }catch (Exception e) {
            //TODO handle error
            Log.d("loadingImg", e.toString());
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button: //simple button
                numPressed++;
                txtView.setText("button pressed:" + numPressed);
                break;
            case R.id.button2: //load img button
                //imgView.setImageResource(R.drawable.androidvsios);
                //imgView.setImageDrawable(loadImageFromURL(googleLogoURL)); // wrong way, android.os.NetworkOnMainThreadException occurred
                (new Thread(new Runnable() { //open a new Thread
                    @Override
                    public void run() {
                        final Drawable imgDrawableFromNetwork = loadImageFromURL(googleLogoURL);
                        uiHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                imgView.setImageDrawable(imgDrawableFromNetwork);
                            }
                        });
                    }
                })).start();
                break;
        }
    }
}

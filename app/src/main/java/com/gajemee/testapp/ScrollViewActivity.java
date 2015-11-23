package com.gajemee.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ScrollViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        TextView view = (TextView) findViewById(R.id.TextView02);
        String s = "";
        for (int i = 0; i < 500; i++){
            s += "JaimeCzek ";
        }
        view.setText(s);
    }
}

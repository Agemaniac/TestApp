package com.gajemee.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText input_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreated called");
        setContentView(R.layout.activity_main);
        input_text = (EditText) findViewById(R.id.inputValue);

        RadioGroup group1 = (RadioGroup) findViewById(R.id.orientation);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.horizontal:
                        group.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                    case R.id.vertical:
                        group.setOrientation(LinearLayout.VERTICAL);
                        break;

                }
            }
        });
    }

    public void onClick(View view){
        Log.d(TAG, "onClick called");
        EditText input = (EditText) findViewById(R.id.main_input);
        String string = input.getText().toString();
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    public void onClickTempConv(View view){

        switch (view.getId()){
            case R.id.button1:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
                if(input_text.getText().length() == 0){
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(input_text.getText().toString());
                if(celsiusButton.isChecked()){
                    input_text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                }else{
                    input_text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
            break;

        }
    }

    public void goToSwitchImagesActivity(View view){
        Intent click = new Intent(view.getContext(), SwitchImagesActivity.class);
        startActivityForResult(click, 0);
    }

    public void goToScrollViewLayout(View view){
        Intent click = new Intent(view.getContext(), ScrollViewActivity.class);
        startActivityForResult(click, 0);
    }
}

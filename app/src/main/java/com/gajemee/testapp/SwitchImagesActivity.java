package com.gajemee.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SwitchImagesActivity extends Activity {
    private static final String TAG = "SwitchImagesActivity";
    private ImageView CURRENT_IMAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_images);
        CURRENT_IMAGE = (ImageView) findViewById(R.id.toggleImage);
        CURRENT_IMAGE.setTag(1);
    }

    public void switchImage(View view){
        Log.d(TAG, "switchImage called");
        ImageView image = (ImageView) findViewById(R.id.toggleImage);
        int i = (Integer) image.getTag();
        Log.d(TAG, "switchImage Image tag:  " + Integer.toString(i));
        switch (i){
            case 1:
                //Its the Stg. Pugsley image!
                //We want to toggle, so we change the image resource to the planet image
                //and change the tag to 2
                image.setImageResource(R.drawable.agro_12);
                image.setTag(2);
                break;
            case 2:
                image.setImageResource(R.drawable.sniper_pug);
                image.setTag(1);
            break;
            default:
                String s = "Tag unknown!!!";
                Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }
}

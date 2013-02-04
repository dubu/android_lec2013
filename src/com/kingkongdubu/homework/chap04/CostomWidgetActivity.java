package com.kingkongdubu.homework.chap04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kingkongdubu.R;

public class CostomWidgetActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_chap041);

/*
            public void onClick(View view) {
                //To change body of implemented methods use File | Settings | File Templates.
                Log.e("ID =========" , String.valueOf(view.getId()))  ;
            }
        });    *


       /*
        for (int i = 1; i < 30; i++) {
            String textDay = "home_chap_textView" + String.valueOf(i)  ;
            Button buttonLoadImage = (Button) findViewById(R.id.home_ch4_customWidget);
            buttonLoadImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    arg0.getId();


                    TextView dayTextView = (TextView) findViewById(R.id.txt_phone);

                }
            });

        }
        */


    }


}

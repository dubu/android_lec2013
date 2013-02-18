package com.kingkongdubu.homework.chap04;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kingkongdubu.R;

/**
 * User: Administrator
 * Date: 13. 1. 31
 * Time: 오후 5:54
 */
public class CustomWidget extends LinearLayout {


    Context context     ;
    View view;

    public CustomWidget(Context context) {
        super(context);
        init(context);
    }

    public CustomWidget(Context context , AttributeSet attrs){
        super(context);
        init(context);

    }

    private void init(Context context) {
        this.context =  context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.homework_chap04,this);


            TextView textView = (TextView) findViewById(R.id.home_chap_textView06);
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //view.getId();
                    //textView.setBackgroundColor(0x0000FF00 );
                    TextView textView = (TextView) findViewById(R.id.home_chap_textView06);
                    textView.setBackgroundColor(0xFFFFFF00 );

                }
            });

    }
}

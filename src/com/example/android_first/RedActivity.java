package com.example.android_first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RedActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red);
    }

    public void btn_blu_click(View view){
        /*
        System.out.println("sdfdssssssssssssssss dxxxxxxxxxxxxxxx");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("만두 mandu ");
        */

        Intent intent = new Intent(this, BlueActivity.class);
        intent.putExtra("result", "메뚜기");
        setResult(RESULT_OK , intent);
        finish();

        //startActivity(intent);
    }
}

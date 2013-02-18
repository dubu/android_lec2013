package com.kingkongdubu.lecture.chap02;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.kingkongdubu.R;

public class MyActivity extends Activity {
    public static final int REQUEST_CODE = 100;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap02_main);
    }


    public void btn_click(View view) {
        /*
        System.out.println("sdfdssssssssssssssss dxxxxxxxxxxxxxxx");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("만두 mandu ");
        */

        Intent intent = new Intent(this, RedActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // 히스토리를 남기지 않는다
        startActivity(intent);
        //startActivity(intent, REQUEST_CODE); // 이거 놓치 었음.
    }

    public void btn_call_click(View view) {
        try {
            Intent callIntenet = new Intent(Intent.ACTION_CALL);
            callIntenet.setData(Uri.parse("tel:0315217844"));
            startActivity(callIntenet);
        } catch (ActivityNotFoundException act) {
            Log.e("Log", act.getMessage());
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getExtras().getString("result");

            }
        }
    }
}

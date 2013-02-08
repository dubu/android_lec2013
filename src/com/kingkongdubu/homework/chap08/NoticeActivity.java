package com.kingkongdubu.homework.chap08;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * User: Administrator
 * Date: 13. 2. 18
 * Time: 오후 6:47
 */
public class NoticeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       Toast toast = Toast.makeText(getApplicationContext(), "돈 많으세요?", Toast.LENGTH_SHORT);
       toast.show();

    }
}

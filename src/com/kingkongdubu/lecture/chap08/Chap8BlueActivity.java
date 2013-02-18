package com.kingkongdubu.lecture.chap08;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.kingkongdubu.R;
import com.kingkongdubu.lecture.chap02.RedActivity;

/**
 * User: Administrator
 * Date: 13. 2. 13
 * Time: 오전 9:12
 * To change this template use File | Settings | File Templates.
 */
public class Chap8BlueActivity extends Activity {

    private final Activity actity;

    public Chap8BlueActivity() {
        super();
        this.actity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap08_blue);

        Button redBtn = (Button) findViewById(R.id.class_chap8_blueButton);




        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(actity, Chap8GreenActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); // 히스토리를 남기지 않는다
                startActivity(intent);
            }
        });





    }


}

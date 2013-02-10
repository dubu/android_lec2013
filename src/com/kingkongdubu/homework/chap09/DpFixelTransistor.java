package com.kingkongdubu.homework.chap09;

import android.view.View;
import android.widget.*;
import com.kingkongdubu.R;
import android.app.Activity;
import android.os.Bundle;
import com.kingkongdubu.lecture.chap09.DipUtils;

/**
 * User: Administrator
 * Date: 13. 2. 10
 * Time: 오후 2:08
 */
public class DpFixelTransistor extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_chap09);

        DipUtils.getInstance().init(this);
        final TextView textView = (TextView)findViewById(R.id.homework_chap09_TextView);
        final EditText editText = (EditText)findViewById(R.id.homework_chap09_EditView);


        Button tBtn  = (Button) findViewById(R.id.homework_chap09_btn);
        tBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer val  = Integer.valueOf(editText.getText().toString());
                String rs = new String();

                int selected = ((RadioGroup)findViewById(R.id.homework_chap09_radioGroup)).getCheckedRadioButtonId();
                if(selected == R.id.homework_chap09_dpToPixel){
                    rs = String.valueOf(DipUtils.getInstance().DpToPixel(val)) ;

                }else if(selected == R.id.homework_chap09_pixelToDp){
                    rs = String.valueOf(DipUtils.getInstance().PixelToDp(val));
                }

                textView.setText(rs);
            }
        });





    }
}

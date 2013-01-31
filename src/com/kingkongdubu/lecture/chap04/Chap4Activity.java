package com.kingkongdubu.lecture.chap04;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import com.kingkongdubu.R;


//public class Chap4Activity extends Activity implements TextView.OnEditorActionListener {
public class Chap4Activity extends Activity  {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap04);

       /*
        EditText editText = (EditText) findViewById(R.id.ch4_editText);
       editText.setOnEditorActionListener(this);

        Button button = (Button) findViewById(R.id.chap4_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });



*/
        // spinner
        Spinner spinner = (Spinner) findViewById(R.id.chap4_spinner);

        String[] data = new String[]{"안드로이디", "아이폰" , "윈도우"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        ProgressBar progressBar  = (ProgressBar) findViewById(R.id.ch4_progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(20);
        progressBar.setSecondaryProgress(90);

        SeekBar seekBar = (SeekBar) findViewById(R.id.ch4_seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //To change body of implemented methods use File | Settings | File Templates.
                TextView textView = (TextView) findViewById(R.id.ch4_editText);
                textView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.

            }
        });



    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate();
        return false;

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.

    }
    */
}

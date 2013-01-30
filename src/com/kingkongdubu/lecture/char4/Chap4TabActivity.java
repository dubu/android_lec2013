package com.kingkongdubu.lecture.char4;



import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.kingkongdubu.R;


public class Chap4TabActivity extends Activity  {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap41);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();       // 이거 뭐지 ? 해줘야 한다고 함.

        // drawalbe 만들기
        Drawable icon =getResources().getDrawable(android.R.drawable.ic_lock_idle_alarm);
        //TabSpec tab1 =   tabHost.newTabSpec("tab1").setIndicator("tab1", icon).setContent(R.id.ch4_tab1);
        //TabSpec tab1 =   tabHost.newTabSpec("tab1").setIndicator("tab1", icon)
        //tabHost.addTab(tab1);

        TabSpec tab1 =   tabHost.newTabSpec("tab1").setIndicator("tab1", icon).setContent(R.id.ch4_tab1);
        tabHost.addTab(tab1);


        TabSpec tab2 =   tabHost.newTabSpec("tab1").setIndicator("tab1", icon).setContent(R.id.ch4_tab2);
        tabHost.addTab(tab1);


        TabSpec tab3 =   tabHost.newTabSpec("tab1").setIndicator("tab1", icon).setContent(R.id.ch4_tab3);
        tabHost.addTab(tab1);



    }

}

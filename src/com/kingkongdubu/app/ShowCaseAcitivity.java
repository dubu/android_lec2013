package com.kingkongdubu.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.kingkongdubu.R;
import com.kingkongdubu.homework.chap02.PhoneCallActivity;
import com.kingkongdubu.homework.chap03.WellActivity;
import com.kingkongdubu.homework.chap04.CostomWidgetActivity;
import com.kingkongdubu.homework.chap05.CustomListViewActivity;
import com.kingkongdubu.homework.chap06.CustomButtonActivity;
import com.kingkongdubu.homework.chap07.HttpActivity;
import com.kingkongdubu.homework.chap08.AlramFoodTickerActivity;
import com.kingkongdubu.lecture.chap02.MyActivity;
import com.kingkongdubu.lecture.chap04.Chap4Activity;
import com.kingkongdubu.lecture.chap04.Chap4TabActivity;
import com.kingkongdubu.lecture.chap05.Chap5Activity;
import com.kingkongdubu.lecture.chap06.Chap6Activity;
import com.kingkongdubu.lecture.chap07.Chap7Activity;
import com.kingkongdubu.lecture.chap08.Chap8RedActivity;

import java.util.ArrayList;

/**
 * User: Administrator
 * Date: 13. 2. 14
 * Time: 오후 3:03
 */
public class ShowCaseAcitivity extends Activity {

    Activity activity;

    public static final int REQUEST_CODE_CL_CH01 = 1010;
    public static final int REQUEST_CODE_CL_CH02 = 1020;
    public static final int REQUEST_CODE_CL_CH03 = 1030;
    public static final int REQUEST_CODE_CL_CH04 = 1040;
    public static final int REQUEST_CODE_CL_CH05 = 1050;
    public static final int REQUEST_CODE_CL_CH06 = 1060;
    public static final int REQUEST_CODE_CL_CH07 = 1070;
    public static final int REQUEST_CODE_CL_CH08 = 1080;
    public static final int REQUEST_CODE_CL_CH09 = 1090;
    public static final int REQUEST_CODE_CL_CH10 = 1100;

    public static final int REQUEST_CODE_HW_CH01 = 2010;
    public static final int REQUEST_CODE_HW_CH02 = 2020;
    public static final int REQUEST_CODE_HW_CH03 = 2030;
    public static final int REQUEST_CODE_HW_CH04 = 2040;
    public static final int REQUEST_CODE_HW_CH05 = 2050;
    public static final int REQUEST_CODE_HW_CH06 = 2060;
    public static final int REQUEST_CODE_HW_CH07 = 2070;
    public static final int REQUEST_CODE_HW_CH08 = 2080;
    public static final int REQUEST_CODE_HW_CH09 = 2090;
    public static final int REQUEST_CODE_HW_CH10 = 2100;

    public ShowCaseAcitivity() {
        super();
        this.activity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.app_showcase);

        final ArrayList<Class> classActivitys = new ArrayList<Class>();
        classActivitys.add( MyActivity.class);
        classActivitys.add( Chap4Activity.class);
        classActivitys.add( Chap4TabActivity.class);
        classActivitys.add( Chap5Activity.class);
        classActivitys.add( Chap6Activity.class);
        classActivitys.add( Chap7Activity.class);
        classActivitys.add( Chap8RedActivity.class);



        final ArrayList<Class> hwActivitys = new ArrayList<Class>();
        hwActivitys.add(0, PhoneCallActivity.class);
        hwActivitys.add(1, WellActivity.class);
        hwActivitys.add(2, CostomWidgetActivity.class);
        hwActivitys.add(3, CustomListViewActivity.class);
        hwActivitys.add(4, CustomButtonActivity.class);
        hwActivitys.add(5, HttpActivity.class);
        hwActivitys.add(6, AlramFoodTickerActivity.class);

        ArrayList<View.OnClickListener> classClickEvents = new ArrayList();
        ArrayList<View.OnClickListener> hwClickEvents = new ArrayList();

        for (int i = 0; i < classActivitys.size(); i++) {
            final int j = i;
            classClickEvents.add(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, classActivitys.get(j));
                    startActivity(intent);
                }
            });
        }

        for (int i = 0; i < hwActivitys.size(); i++) {
            final int j = i;
            hwClickEvents.add(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, hwActivitys.get(j));
                    startActivity(intent);
                }
            });
        }

        Button btn_class01 = (Button) findViewById(R.id.app_btn_class01);
        Button btn_class02 = (Button) findViewById(R.id.app_btn_class02);
        Button btn_class03 = (Button) findViewById(R.id.app_btn_class03);
        Button btn_class04 = (Button) findViewById(R.id.app_btn_class04);
        Button btn_class05 = (Button) findViewById(R.id.app_btn_class05);
        Button btn_class06 = (Button) findViewById(R.id.app_btn_class06);
        Button btn_class07 = (Button) findViewById(R.id.app_btn_class07);


        btn_class01.setOnClickListener(classClickEvents.get(0));
        btn_class02.setOnClickListener(classClickEvents.get(1));
        btn_class03.setOnClickListener(classClickEvents.get(2));
        btn_class04.setOnClickListener(classClickEvents.get(3));
        btn_class05.setOnClickListener(classClickEvents.get(4));
        btn_class06.setOnClickListener(classClickEvents.get(5));
        btn_class07.setOnClickListener(classClickEvents.get(6));



        Button btn_hw01 = (Button) findViewById(R.id.app_btn_hw01);
        Button btn_hw02 = (Button) findViewById(R.id.app_btn_hw02);
        Button btn_hw03 = (Button) findViewById(R.id.app_btn_hw03);
        Button btn_hw04 = (Button) findViewById(R.id.app_btn_hw04);
        Button btn_hw05 = (Button) findViewById(R.id.app_btn_hw05);
        Button btn_hw06 = (Button) findViewById(R.id.app_btn_hw06);
        Button btn_hw07 = (Button) findViewById(R.id.app_btn_hw07);

        btn_hw01.setOnClickListener(hwClickEvents.get(0));
        btn_hw02.setOnClickListener(hwClickEvents.get(1));
        btn_hw03.setOnClickListener(hwClickEvents.get(2));
        btn_hw04.setOnClickListener(hwClickEvents.get(3));
        btn_hw05.setOnClickListener(hwClickEvents.get(4));
        btn_hw06.setOnClickListener(hwClickEvents.get(5));
        btn_hw07.setOnClickListener(hwClickEvents.get(6));




    }
}

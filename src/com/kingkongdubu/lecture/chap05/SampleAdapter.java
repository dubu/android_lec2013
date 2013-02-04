package com.kingkongdubu.lecture.chap05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kingkongdubu.R;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 2. 4
 * Time: 오전 9:35
 * To change this template use File | Settings | File Templates.
 */


public class SampleAdapter extends BaseAdapter {

    private final int ID_IMAGEVIEW = 0x00000001;
    private final int ID_TITLEVIEW = 0x00000002;
    private final int ID_DESCRIONTIONVIEW = 0x00000003;


    private ArrayList<ItemData> itemlist;
    private Activity activity;


    public SampleAdapter(ArrayList<ItemData> itemlist, Activity activity) {
        this.itemlist = itemlist;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        //return 0;  //To change body of implemented methods use File | Settings | File Templates.
        return itemlist.size();
    }

    @Override
    public Object getItem(int i) {
        return itemlist.get(i);
        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int i) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 반드시 구현해야 되는 method 임!!!

        // 새로운 view가 올라올때 불리는 callback 함수
        // 재활용 할것인가.. 새로 만들것인??

        // 1 step 뷰 얻기 단계
        if (convertView == null) {
            //case01  직접 호출
            //convertView = createItemView(parent.getContext());

            //case02
            // xml layout file  java instance 로 변환하기.
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.class_chap05_itemview, parent, false);          // false  ???

        }

        // 2 step 뷰 조회 단계
        /*
        ImageView imageView = (ImageView) convertView.findViewById(ID_IMAGEVIEW);
        TextView titleView = (TextView) convertView.findViewById(ID_TITLEVIEW);
        TextView deTextView = (TextView) convertView.findViewById(ID_DESCRIONTIONVIEW);
        */

        ImageView imageView = (ImageView) convertView.findViewById(R.id.lec_char5_imageView);
        TextView titleView = (TextView) convertView.findViewById(R.id.lec_char5_titleText);
        TextView deTextView = (TextView) convertView.findViewById(R.id.lec_char5_descText);

        //3 list  뷰 조작 단계
        imageView.setBackgroundResource(itemlist.get(position).getImageResourceId());
        titleView.setText(itemlist.get(position).getTitleText());
        deTextView.setText(itemlist.get(position).getDiscriptionText());


        return convertView;  // return null 이면 에러
    }

    private View createItemView(Context context) {
        RelativeLayout root = new RelativeLayout(context);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        params.leftMargin = 10;
        params.topMargin = 10;
        params.rightMargin = 10;
        params.bottomMargin = 10;

        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(params);
        imageView.setId(ID_IMAGEVIEW);

        TextView titleText = new TextView(context);
        params = new RelativeLayout.LayoutParams(300, 50);
        params.addRule(RelativeLayout.RIGHT_OF, ID_IMAGEVIEW);
        titleText.setLayoutParams(params);
        titleText.setId(ID_TITLEVIEW);

        TextView descriptioneText = new TextView(context);
        params = new RelativeLayout.LayoutParams(300, 50);
        params.addRule(RelativeLayout.RIGHT_OF, ID_IMAGEVIEW);
        params.addRule(RelativeLayout.BELOW, ID_TITLEVIEW);
        descriptioneText.setLayoutParams(params);
        descriptioneText.setId(ID_DESCRIONTIONVIEW);

        root.addView(imageView);
        root.addView(titleText);
        root.addView(descriptioneText);


        return root;
    }
}

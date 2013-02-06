package com.kingkongdubu.homework.chap05;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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


public class CusDownListVeiwAdapter extends BaseAdapter {

    private ArrayList<CusItemData> itemlist;
    private Activity activity;

    public CusDownListVeiwAdapter(ArrayList<CusItemData> itemlist, Activity activity) {
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

        if (convertView == null) {

            LayoutInflater layoutInflater = activity.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.homework_chap05_down, parent, false);

        }

        TextView titleView = (TextView) convertView.findViewById(R.id.homework_ch5_down_titleText);
        TextView deTextView = (TextView) convertView.findViewById(R.id.homework_ch5_down_descText);

        titleView.setText(itemlist.get(position).getTitleText());
        deTextView.setText(itemlist.get(position).getDiscriptionText());
        return convertView;  // return null 이면 에러
    }

}

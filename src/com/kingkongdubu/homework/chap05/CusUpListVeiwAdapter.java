package com.kingkongdubu.homework.chap05;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.kingkongdubu.R;

import java.util.ArrayList;


/**
 * User: Administrator
 * Date: 13. 2. 4
 * Time: 오전 9:35
 */


public class CusUpListVeiwAdapter extends BaseAdapter {

    private ArrayList<CusItemData> itemlist;
    private Activity activity;
    private Context context;

    public CusUpListVeiwAdapter(Context context ,ArrayList<CusItemData> itemlist, Activity activity) {
        this.context = context;
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
            convertView = layoutInflater.inflate(R.layout.homework_chap05_up, parent, false);

        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.homework_ch5_up_imageView);
        TextView titleView = (TextView) convertView.findViewById(R.id.homework_ch5_up_titleText);
        TextView deTextView = (TextView) convertView.findViewById(R.id.homework_ch5_up_descText);

        imageView.setBackgroundResource(itemlist.get(position).getImageResourceId());
        titleView.setText(itemlist.get(position).getTitleText());
        deTextView.setText(itemlist.get(position).getDiscriptionText());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView titleView = (TextView) view.findViewById(R.id.homework_ch5_up_titleText);
                Toast toast = Toast.makeText(context, titleView.getText(), Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        return convertView;  // return null 이면 에러
    }

}

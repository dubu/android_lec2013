package com.kingkongdubu.homework.chap05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.kingkongdubu.R;

import java.util.ArrayList;

/**
 * User: Administrator
 * Date: 13. 2. 6
 * Time: 오후 12:26
 */
public class CustomListViewActivity  extends Activity{
    ArrayList<CusItemData> itemlist;
    ListView upListView ;
    ListView downListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_chap05);
        itemlist = new ArrayList<CusItemData>();

        for (int i=0 ; i <30 ;i++){
            CusItemData cusItemData = new CusItemData();
            cusItemData.setTitleText(String.format("Title %d",i));
            cusItemData.setDiscriptionText(String.format("Discription %d", i));
            cusItemData.setImageResourceId(R.drawable.dubu);
            itemlist.add(cusItemData);
        }

        upListView = (ListView) findViewById(R.id.home_chap5_uplistView);
        upListView.setAdapter(new CusUpListVeiwAdapter(this , itemlist, this));

        downListView = (ListView) findViewById(R.id.home_chap5_downlistView);
        downListView.setAdapter(new CusDownListVeiwAdapter(this ,itemlist, this));


    }
}

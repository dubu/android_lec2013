package com.kingkongdubu.homework.chap05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.kingkongdubu.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 2. 6
 * Time: 오후 12:26
 * To change this template use File | Settings | File Templates.
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
        upListView.setAdapter(new CusUpListVeiwAdapter(itemlist, this));

        downListView = (ListView) findViewById(R.id.home_chap5_downlistView);
        downListView.setAdapter(new CusDownListVeiwAdapter(itemlist, this));

        /*
        // 요거 적용하기
        Toast toast = Toast.makeText(this, "메세지 입력.",
                Toast.LENGTH_SHORT);
        toast.show();
        */
    }
}

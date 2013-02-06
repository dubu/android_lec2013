package com.kingkongdubu.lecture.chap05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import com.kingkongdubu.R;

import java.util.ArrayList;


//public class Chap4Activity extends Activity implements TextView.OnEditorActionListener {
public class Chap5Activity extends Activity {
    ArrayList<ItemData> itemlist;
    ListView listView ;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_chap05);
        itemlist = new ArrayList<ItemData>();

        for (int i=0 ; i <30 ;i++){
            ItemData itemData = new ItemData();
            itemData.setTitleText(String.format("Title %d",i));
            itemData.setDiscriptionText(String.format("Discription %d", i));
            itemData.setImageResourceId(R.drawable.lec_chap5_dubu);
            itemlist.add(itemData);
        }

        listView = (ListView) findViewById(R.id.class_ch5_listView);

        //Adapter adapter = new CusUpListVeiwAdapter(listView)    ;

        listView.setAdapter(new SampleAdapter(itemlist, this));


    }


}

package com.kingkongdubu.homework.chap07;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kingkongdubu.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 2. 13
 * Time: 오후 7:46
 * To change this template use File | Settings | File Templates.
 */
public class SampleAdapter extends BaseAdapter {

    private ArrayList<RowData> dataset;
    private Activity activity;

    public SampleAdapter(ArrayList<RowData> dataset, Activity activity) {
        this.dataset = dataset;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int i) {
        return dataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.homework_chap07_itemview, viewGroup, false);
        }

        TextView folderNameTextView = (TextView) view.findViewById(R.id.homework_chap07_nameTextView);
        TextView createdDateTextView = (TextView) view.findViewById(R.id.homework_chap07_createdDateTextView);

        folderNameTextView.setText(dataset.get(i).getName());
        createdDateTextView.setText(dataset.get(i).getCreated());
        return view;

    }
}

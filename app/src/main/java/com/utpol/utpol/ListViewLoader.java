package com.utpol.utpol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewLoader extends BaseAdapter {


    Context context;
    List objectList;
    LayoutInflater inflter;

    public ListViewLoader(Context applicationContext, List objectList) {
        this.context = applicationContext;
        this.objectList = objectList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);
        TextView listObject = (TextView) view.findViewById(R.id.listViewTextView);
        listObject.setText(objectList.get(i).toString());
        return view;
    }

}

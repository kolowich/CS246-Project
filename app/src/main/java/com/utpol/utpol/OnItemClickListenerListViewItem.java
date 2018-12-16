package com.utpol.utpol;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView textViewItem = ((TextView) view.findViewById(R.id.listViewTextView));

        // get the clicked item name
        String listItemText = textViewItem.getText().toString();

        // broadcast the clicked item contents to listeners
        Intent intent = new Intent("custom-message");
        intent.putExtra("text",listItemText);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

    }

}

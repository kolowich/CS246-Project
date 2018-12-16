package com.utpol.utpol;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The type On item click listener list view item.
 */
public class OnItemClickListenerListViewItem implements AdapterView.OnItemClickListener {

    /**
     * This finds the text that is displayed in the text view inside the list view and sends a message with the information for the item that has been clicked.
     */
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

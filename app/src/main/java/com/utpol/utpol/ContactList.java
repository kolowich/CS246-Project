package com.utpol.utpol;

import android.app.Activity;
import android.widget.BaseAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactList extends Activity implements ListView {

    private static List<ContactDetail> details;

    public ContactList(){
        details = new ArrayList<>();
    }

    public void pullList(android.widget.ListView listView){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Person");
        query.selectKeys(Arrays.asList("First","Last","Phone")).setLimit(500);

        query.findInBackground(new FindCallback<ParseObject> () {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null) {
                    if (objects != null) {
                        for (ParseObject object : objects) {
                            runOnUiThread(() -> {
                                addContact(object.getObjectId(), object.getString("First"), object.getString("Last"), object.getString("Phone"));
                                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
                            });
                        }
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void addContact(String objectId, String first, String last, String number) {
        boolean exists = false;

        for(ContactDetail current: details) {

            boolean isFirst = false;
            boolean isLast = false;
            boolean isPhone = false;

            if (current.getFirstName() != null) {
                if (current.getFirstName().equals(first)) {
                    isFirst = true;
                }
            } else if (first == null) {
                isFirst = true;
            }

            if (current.getLastName() != null) {
                if (current.getLastName().equals(last)) {
                    isLast = true;
                }
            } else if (last == null) {
                isLast = true;
            }

            if (current.getPhoneNumber() != null) {
                if (current.getPhoneNumber().equals(number)) {
                    isPhone = true;
                }
            } else if (number == null) {
                isPhone = true;
            }

            if (isFirst && isLast && isPhone) {
                exists = true;
            }
        }
        if(!exists) {
            details.add(new ContactDetail(objectId, first, last, number));
        }

    }

    public List<ContactDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ContactDetail> details) {
        this.details.addAll(details);
    }
}

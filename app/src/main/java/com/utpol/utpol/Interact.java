package com.utpol.utpol;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Interact.
 */
public class Interact {


    private List<ParseObject> response;
    private String request;


    public Interact(){
        response = new ArrayList<>();
    }

    /**
     * Server request connects to the database.
     */
    public void serverRequest() {
        //successful query example
        Collection<String> keys = new ArrayList<>();
        keys.add("First");
        keys.add("Last");

        ParseQuery<ParseObject> query = ParseQuery.getQuery(request);
        query.whereEqualTo("Committee", "Natural Resources, Agriculture, and Environmental Quality Appropriations Subcommittee")
                .whereEqualTo("Email", "leeperry@le.utah.gov");

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> peopleList, ParseException e) {
                if (e == null) {
                    Log.d("person", "Retrieved " + peopleList.get(0).getString("First"));
                    response = peopleList;
                    printList();

                } else {
                    Log.d("person", "Error: ");
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Print list.
     */
    public void printList(){
        //other stuff
        for (ParseObject obj : response) {
            String outString = obj.getString("First") + " " + obj.getString("Last");
            System.out.println(outString);

        }
    }

    public String getResponse() {
        return response.toString();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}

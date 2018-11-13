package com.utpol.utpol;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.http.ParseHttpRequest;

import java.util.List;

public class Interact {


    private String response;
    private String request;


    public Interact(){
    }

    public void serverRequest(){

        ParseQuery<ParseObject> query = ParseQuery.getQuery(request);
        query.whereEqualTo("Committee","Natural Resources, Agriculture, and Environmental Quality Appropriations Subcommittee");
        query.whereEqualTo("Email", "leeperry@le.utah.gov");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> peopleList, ParseException e) {
                if (e == null) {
                    Log.d("person", "Retrieved " + peopleList.get(0).getString("First"));
                    response = peopleList.toString();

                } else {
                    Log.d("person", "Error: ");
                    e.printStackTrace();
                }
            }
        });

        try {
            response = query.getFirst().getString("First") + " " + query.getFirst().getString("Last");
            System.out.println(response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}

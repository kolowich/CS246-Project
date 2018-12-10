package com.utpol.utpol;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class HomeScreen extends ConstraintLayout {

    public static final String LOCATION = "location";

    private List<String> messages;
    private int date;
    private String location;
    private ContactList contacts;
    private BillList bills;
    private CommitteeList committees;

    /**
     *
     * @param context
     * @param locationIn
     */
    public HomeScreen(Context context, String locationIn) {
        super(context);

        location = "Weber";

        if(locationIn != null){
            location = locationIn;
        }

        SharedPreferences pref = context.getSharedPreferences("utpol",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(LOCATION , location);

        //Create Bill, Contact, and Committee over to the side.
        bills = new BillList();
        contacts = new ContactList();
        committees = new CommitteeList();
    }


    public void HomeScreen() {

    }


    public void openContacts(){

    }

    public void openBills(){

    }

    public void openCommittees(){

    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ContactList getContacts() {
        return contacts;
    }

    public void setContacts(ContactList contacts) {
        this.contacts = contacts;
    }

    public BillList getBills() {
        return bills;
    }

    public void setBills(BillList bills) {
        this.bills = bills;
    }

    public CommitteeList getCommittees() {
        return committees;
    }

    public void setCommittees(CommitteeList committees) {
        this.committees = committees;
    }
}

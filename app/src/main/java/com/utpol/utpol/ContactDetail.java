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
import java.util.Map;

public class ContactDetail extends Activity implements DetailView {
    
    private String objectID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeTown;
    private List<String> education = new ArrayList<>();
    private Address address;
    private Electronic eContact;
    private GovInfo govInfo;

    public ContactDetail(){
    }

    public ContactDetail(String id, String first, String last, String phone) {
        objectID = id;
        firstName = first;
        lastName = last;
        phoneNumber = phone;
    }

    public void pullAdditionalDetail(){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Person").whereEqualTo("objectId", objectID);

        updated = false;

        query.findInBackground((objects, e) -> {
            if (e == null) {
                if (objects != null) {
                    for (ParseObject object : objects) {
                        runOnUiThread(() -> {
                            this.addDetails(object);
                        });
                    }
                }
            } else {
                e.printStackTrace();
            }
        });
    }

    public void addDetails(ParseObject in) {
        if(in.getString("Background") != null) {
            education.add(in.getString("Background"));
        }
        if(in.getString("City") != null) {
            homeTown = in.getString("City");
        }
        if(in.getString("Street") != null && in.getString("City") != null && in.getString("State") != null && in.getString("Zip") != null) {
            address = new Address(in.getString("Street"), in.getString("City"), in.getString("State"), in.getString("Zip"));
        } else {
            address = new Address();
            if(in.getString("Street") != null){
                address.setStreet(in.getString("Street"));
            }
            if(in.getString("City") != null){
                address.setCity(in.getString("City"));
            }
            if(in.getString("State") != null){
                address.setState(in.getString("State"));
            }
            if(in.getString("Zip") != null){
                address.setZip(in.getString("Zip"));
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Electronic geteContact() {
        return eContact;
    }

    public void seteContact(Electronic eContact) {
        this.eContact = eContact;
    }

    public GovInfo getGovInfo() {
        return govInfo;
    }

    public void setGovInfo(GovInfo govInfo) {
        this.govInfo = govInfo;
    }

    @Override
    public String toString(){
        String string = new String();
        string = this.firstName + " " + this.lastName;
        if(this.phoneNumber != null){
            string = this.firstName + " " + this.lastName + "\n" + this.phoneNumber;
        }
        return string;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
}

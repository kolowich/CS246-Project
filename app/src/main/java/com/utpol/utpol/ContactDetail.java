package com.utpol.utpol;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * The type Contact detail.
 */
public class ContactDetail extends Activity {

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
        eContact = new Electronic();
        govInfo = new GovInfo();
    }

    /**
     * Pull additional detail gets the additional details from the database and sends them to the display.
     *
     * @param contactNameTextViewName               the contact name text view name
     * @param contactNameTextViewParty              the contact name text view party
     * @param contactNameTextViewDistrict           the contact name text view district
     * @param contactNameTextViewLeadershipPosition the contact name text view leadership position
     * @param contactLocationTextViewLocation       the contact location text view location
     * @param contactContInfoTextViewStreet         the contact cont info text view street
     * @param contactContInfoTextViewCityStateZip   the contact cont info text view city state zip
     * @param contactContInfoTextViewPhone          the contact cont info text view phone
     * @param contactContInfoTextViewEmail          the contact cont info text view email
     * @param contactContInfoTextViewTwitter        the contact cont info text view twitter
     * @param contactInternTextViewName             the contact intern text view name
     * @param contactCommitteeTextViewCommittee     the contact committee text view committee
     * @param contactEduTextViewDegreeMajorSchool   the contact edu text view degree major school
     */
    public void pullAdditionalDetail(TextView contactNameTextViewName, TextView contactNameTextViewParty, TextView contactNameTextViewDistrict, TextView contactNameTextViewLeadershipPosition, TextView contactLocationTextViewLocation, TextView contactContInfoTextViewStreet, TextView contactContInfoTextViewCityStateZip, TextView contactContInfoTextViewPhone, TextView contactContInfoTextViewEmail, TextView contactContInfoTextViewTwitter, TextView contactInternTextViewName, TextView contactCommitteeTextViewCommittee, TextView contactEduTextViewDegreeMajorSchool){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Person").whereEqualTo("objectId", objectID);

        query.findInBackground((objects, e) -> {
            if (e == null) {
                if (objects != null) {
                    for (ParseObject object : objects) {
                        runOnUiThread(() -> {
                            this.addDetails(object);
                            if(firstName != null && lastName != null){
                                contactNameTextViewName.setText(firstName + " " + lastName);
                            }
                            if(govInfo != null && govInfo.getParty() != null){
                                contactNameTextViewParty.setText(govInfo.getParty());
                            }
                            if(govInfo != null && govInfo.getDistrictNumber() != null){
                                contactNameTextViewDistrict.setText("District " + govInfo.getDistrictNumber());
                            }
                            if(govInfo != null && govInfo.getLeadPos() != null){
                                contactNameTextViewLeadershipPosition.setText(govInfo.getLeadPos());
                            }
                            if(govInfo != null && govInfo.getLocation() != null){
                                contactLocationTextViewLocation.setText(govInfo.getLocation());
                            }
                            if(address != null && address.getStreet() != null){
                                contactContInfoTextViewStreet.setText(address.getStreet());
                            }
                            if(address != null && address.getCity() != null && address.getState() != null && address.getZip() != null){
                                contactContInfoTextViewCityStateZip.setText(address.getCity() + ", " + address.getState() + " " + address.getZip());
                            }
                            if(phoneNumber != null){
                                contactContInfoTextViewPhone.setText(phoneNumber);
                            }
                            if(eContact != null && eContact.getEmail() != null){
                                contactContInfoTextViewEmail.setText(eContact.getEmail());
                            }
                            if(eContact != null && eContact.getTwitter() != null){
                                contactContInfoTextViewTwitter.setText(eContact.getTwitter());
                            }
                            if(govInfo != null && govInfo.getInterns() != null){
                                for(String intern: govInfo.getInterns()) {
                                    contactInternTextViewName.setText(intern + "\n");
                                }
                            }
                            if(govInfo != null && govInfo.getCommittees() != null){
                                for(CommitteeDetail committee: govInfo.getCommittees()) {
                                    contactCommitteeTextViewCommittee.setText(committee.getNameCommittee() + "\n");
                                }
                            }
                            if(education != null){
                                for(String educationString: education) {
                                    contactEduTextViewDegreeMajorSchool.setText(educationString + "\n");
                                }
                            }
                        });
                    }
                }
            } else {
                e.printStackTrace();
            }
        });
    }

    /**
     * Add details.
     *
     * @param in the in
     */
    public void addDetails(ParseObject in) {
        if(in.getString("Background") != null) {
            education.add(in.getString("Background"));
        }
        if(in.getString("Email") != null) {
            eContact.setEmail(in.getString("Email"));
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

package com.utpol.utpol;

import java.util.List;
import java.util.Map;

public class ContactDetail implements DetailView {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String homeTown;
    private List<String> education;
    private Address address;
    private Electronic eContact;
    private GovInfo govInfo;

    public ContactDetail(){
    }

    public void pullAdditionalDetail(){

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
}

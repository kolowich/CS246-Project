package com.utpol.utpol;

import android.widget.TextView;

import com.parse.ParseObject;

import java.util.Map;

public class BillDetail{

    private String name;
    private String sponsor;
    private String floorSponsor;
    private String draftingAttorney;
    private CommitteeDetail committee;
    private String floorStatus;
    private String date;
    private String location;
    private Map<String, Vote> vote;

    public BillDetail(){
    }

    public BillDetail(ParseObject in) {

    }

    public void pullAdditionalDetail(){

        // TODO Add the code to display the contact in the various parts of the contact detail screen

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getFloorSponsor() {
        return floorSponsor;
    }

    public void setFloorSponsor(String floorSponsor) {
        this.floorSponsor = floorSponsor;
    }

    public String getDraftingAttorney() {
        return draftingAttorney;
    }

    public void setDraftingAttorney(String draftingAttorney) {
        this.draftingAttorney = draftingAttorney;
    }

    public CommitteeDetail getCommittee() {
        return committee;
    }

    public void setCommittee(CommitteeDetail committee) {
        this.committee = committee;
    }

    public String getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Vote> getVote() {
        return vote;
    }

    public void setVote(Map<String, Vote> vote) {
        this.vote = vote;
    }

    @Override
    public String toString(){
        String string = new String();
        string = this.name + " " + this.committee.getNameCommittee();
        return string;
    }
}

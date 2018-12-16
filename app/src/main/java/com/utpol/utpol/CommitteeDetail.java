package com.utpol.utpol;

import android.widget.TextView;

import java.util.List;

/**
 * The type Committee detail.
 */
public class CommitteeDetail{

    private List<Member> members;
    private String nameCommittee;
    private String dateNextMeeting;
    private String locationNextMeeting;


    public CommitteeDetail(){
    }

    /**
     * Pull additional detail.
     */
    public void pullAdditionalDetail(){

        // TODO Add the code to display the contact in the various parts of the contact detail screen

    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getNameCommittee() {
        return nameCommittee;
    }

    public void setNameCommittee(String nameCommittee) {
        this.nameCommittee = nameCommittee;
    }

    public String getDateNextMeeting() {
        return dateNextMeeting;
    }

    public void setDateNextMeeting(String dateNextMeeting) {
        this.dateNextMeeting = dateNextMeeting;
    }

    public String getLocationNextMeeting() {
        return locationNextMeeting;
    }

    public void setLocationNextMeeting(String locationNextMeeting) {
        this.locationNextMeeting = locationNextMeeting;
    }

    @Override
    public String toString(){
        return this.nameCommittee;
    }
}

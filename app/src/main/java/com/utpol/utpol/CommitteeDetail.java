package com.utpol.utpol;

import java.util.List;

public class CommitteeDetail implements DetailView {

    private List<Member> members;
    private String nameCommittee;
    private String dateNextMeeting;
    private String locationNextMeeting;


    public CommitteeDetail(){
    }

    public void pullAdditionalDetail(){

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

package com.utpol.utpol;

import java.util.List;

/**
 * The type Gov info.
 */
public class GovInfo {

    private String party;
    private String districtNumber;
    private String leadPos;
    private String location;
    private List<CommitteeDetail> committees;
    private List<String> interns;
    private Boolean isSenate;

    public GovInfo(){
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(String districtNumber) {
        this.districtNumber = districtNumber;
    }

    public String getLeadPos() {
        return leadPos;
    }

    public void setLeadPos(String leadPos) {
        this.leadPos = leadPos;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<CommitteeDetail> getCommittees() {
        return committees;
    }

    public void setCommittees(List<CommitteeDetail> committees) {
        this.committees = committees;
    }

    public List<String> getInterns() {
        return interns;
    }

    public void setInterns(List<String> interns) {
        this.interns = interns;
    }

    public Boolean getSenate() {
        return isSenate;
    }

    public void setSenate(Boolean senate) {
        isSenate = senate;
    }
}

package com.utpol.utpol;

import java.util.List;

public class CommitteeList implements ListView {

    private List<CommitteeDetail> details;

    public CommitteeList(){
    }

    public void pullList(){

    }

    public void openDetail(){

    }

    public List<CommitteeDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CommitteeDetail> details) {
        this.details = details;
    }
}

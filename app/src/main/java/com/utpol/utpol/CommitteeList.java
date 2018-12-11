package com.utpol.utpol;

import java.util.ArrayList;
import java.util.List;

public class CommitteeList implements ListView {

    private List<CommitteeDetail> details;

    public CommitteeList(){
        details = new ArrayList<>();
    }

    public void pullList(android.widget.ListView listView){
        // TODO Get the list of committees from the database and place them in the details
    }

    public List<CommitteeDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CommitteeDetail> details) {
        this.details.addAll(details);
    }
}

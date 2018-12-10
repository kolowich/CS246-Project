package com.utpol.utpol;

import java.util.ArrayList;
import java.util.List;

public class BillList implements ListView {

    private List<BillDetail> details;

    public BillList(){
        details = new ArrayList<>();
    }

    public void pullList(){

    }

    public void openDetail(){

    }

    public List<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BillDetail> details) {
        this.details = details;
    }
}

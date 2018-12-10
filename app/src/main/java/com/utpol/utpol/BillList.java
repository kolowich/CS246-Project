package com.utpol.utpol;

import java.util.ArrayList;
import java.util.List;

public class BillList implements ListView {

    private List<BillDetail> details;

    public BillList(){
        details = new ArrayList<>();
    }

    public static void addBill() {
    }

    public void pullList(){
        // TODO Get the list of bills from the database and place them in the details
    }

    public List<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BillDetail> details) {
        this.details.addAll(details);
    }
}

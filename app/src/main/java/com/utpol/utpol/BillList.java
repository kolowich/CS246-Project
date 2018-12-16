package com.utpol.utpol;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Bill list.
 */
public class BillList implements ListView {

    private List<BillDetail> details;

    public BillList(){
        details = new ArrayList<>();
    }

    public static void addBill() {
    }

    /**
     * Pull list goes to the database and gets the list then sends it for display on the list screen.
     *
     * @param listView the listView that needs to be updated
     */
    public void pullList(android.widget.ListView listView){
        // TODO Get the list of bills from the database and place them in the details
    }

    public List<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BillDetail> details) {
        this.details.addAll(details);
    }
}

package com.utpol.utpol;

import java.util.List;

public class ContactList implements ListView {

    private List<ContactDetail> details;

    public ContactList(){
    }

    public void pullList(){

    }

    public void openDetail(){

    }

    public List<ContactDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ContactDetail> details) {
        this.details = details;
    }
}

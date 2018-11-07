package com.utpol.utpol;

public enum Vote {

    Yes("Yes"),
    No("No"),
    Maybe("Maybe"),
    Unknown("Unknown");

    private String status;

    Vote(String status) {
        this.status = status;
    }

    public static Vote getByCode(String status) {
        for(Vote vote: Vote.values()) {
            if(vote.status.equals(status)) {
                return vote;
            }
        }
        return null;
    }

}

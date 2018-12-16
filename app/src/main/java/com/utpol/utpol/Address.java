package com.utpol.utpol;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String streetIn, String cityIn, String stateIn, String zipIn) {
        street = streetIn;
        city = cityIn;
        state = stateIn;
        zip = zipIn;
    }

    public Address() {
    }

    public String fullAddress() {
        String out = new String();
        out.concat(street).concat("\n").concat(city).concat(", ").concat(state).concat(" ").concat(zip);
        System.out.println(out);

        return out;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

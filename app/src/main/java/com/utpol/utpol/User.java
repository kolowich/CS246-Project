package com.utpol.utpol;

public class User {

    private String userName;
    private String password;

    public User(String userName, String password){
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}

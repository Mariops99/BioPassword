package com.marioprieto.biopassword;

public class Password {

    int ID;
    String identifyer, username, password;

    public Password() {

    }

    public Password(int ID, String identifyer, String username, String password) {
        this.ID = ID;
        this.identifyer = identifyer;
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIdentifyer() {
        return identifyer;
    }

    public void setIdentifyer(String identifyer) {
        this.identifyer = identifyer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

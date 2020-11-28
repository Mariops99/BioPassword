package com.marioprieto.biopassword;

public class Password {

    String identifyer, username, password;

    public Password() {

    }

    public Password(String identifyer, String username, String password) {
        this.identifyer = identifyer;
        this.username = username;
        this.password = password;
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

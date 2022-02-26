package com.example.ltserver;

public class User {
    protected String username;
    protected String password;
    protected String email;
    protected String code;
    protected int state;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode(){return code;}

    public void setCode(String code){this.code=code;}

    public int getState(){return state;}

    public void setState(int state){this.state=state;}




}

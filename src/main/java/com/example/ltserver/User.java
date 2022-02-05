package com.example.ltserver;

import java.util.Date;

public class User {
    protected String username;
    protected String password;
    protected String email;
    protected String code;
    protected int state;
    protected Date time;

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

    public Date getTime(){return time;}

    public void setTime(Date time){this.time=time;}

//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}

package com.patel.helpifymp.Models;

public class Users {
    String username, userage , usermobile , useremail , userpassword ;

    public Users(String username, String userage, String usermobile, String useremail, String userpassword) {
        this.username = username;
        this.userage = userage;
        this.usermobile = usermobile;
        this.useremail = useremail;
        this.userpassword = userpassword;
    }

    public Users(){}

    public Users(String useremail, String userpassword) {
        this.useremail = useremail;
        this.userpassword = userpassword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}

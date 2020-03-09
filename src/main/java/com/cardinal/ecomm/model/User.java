package com.cardinal.ecomm.model;

import java.math.BigInteger;

public class User
{
    private int    user_id;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private long   phone;
    private String address;
    private String city;
    private String state;
    private String postal_code;
    private String country;
    private int    logged_flag;



    public User(int user_id, String fname, String lname, String email, long phone, String address, String city, String state, String postal_code, String country, int logged_flag)
    {
        this.user_id = user_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.logged_flag = logged_flag;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLogged_flag() {
        return logged_flag;
    }

    public void setLogged_flag(int logged_flag) {
        this.logged_flag = logged_flag;
    }


}

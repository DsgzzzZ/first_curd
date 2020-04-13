package com.ddz.demo.po;

public class User {
    private Integer userId;
    private String username;
    private String phoneNumber;
    private Integer blacklist;

    public User() {
    }

    public User(Integer userId, String username, String phoneNumber, Integer blacklist) {
        this.userId = userId;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.blacklist = blacklist;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Integer blacklist) {
        this.blacklist = blacklist;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", blacklist=" + blacklist +
                '}';
    }
}

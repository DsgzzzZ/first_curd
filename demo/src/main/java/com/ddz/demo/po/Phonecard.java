package com.ddz.demo.po;

public class Phonecard {
    private Integer phoneNumber;
    private String username;
    private String operator;
    private int receiveQualifications;
    private int surplusFlow;

    public Phonecard(){}

    public Phonecard(Integer phoneNumber, String username, String operator, int receiveQualifications, int surplusFlow) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.operator = operator;
        this.receiveQualifications = receiveQualifications;
        this.surplusFlow = surplusFlow;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getReceiveQualifications() {
        return receiveQualifications;
    }

    public void setReceiveQualifications(int receiveQualifications) {
        this.receiveQualifications = receiveQualifications;
    }

    public int getSurplusFlow() {
        return surplusFlow;
    }

    public void setSurplusFlow(int surplusFlow) {
        this.surplusFlow = surplusFlow;
    }

    @Override
    public String toString() {
        return "phonecard{" +
                "phoneNumber=" + phoneNumber +
                ", username='" + username + '\'' +
                ", operator='" + operator + '\'' +
                ", receiveQualifications=" + receiveQualifications +
                ", surplusFlow=" + surplusFlow +
                '}';
    }
}

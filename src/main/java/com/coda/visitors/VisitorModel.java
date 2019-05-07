package com.coda.visitors;

import java.sql.Time;
import java.util.Date;

public class VisitorModel {

    private String inTime;
    private String outTime;
    private String visitorName;
    private String companyName;
    private String  phoneNum;
    private String personToContact;
    private String currentdate;


    public String getInTime(String timeValue) {
        return inTime;
    }
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }
    public String getOutTime(String timeValue) {
        return outTime;
    }
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }
    public String getVisitorName() {
        return visitorName;
    }
    public void setName(String name) {
        visitorName = name;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getPersonToContact() {
        return personToContact;
    }
    public void setPersonToContact(String personToContact) {
        this.personToContact = personToContact;
    }
    public String getCurrentdate(String dateValue) {
        return currentdate;
    }
    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate;
    }



}

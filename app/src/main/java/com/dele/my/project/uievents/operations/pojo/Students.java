package com.dele.my.project.uievents.operations.pojo;

public class Students {

    private String uuid;
    private String fullName;
    private String emailAddress;
    private String studentNo;

    public Students() {
    }

    public Students(String uuid, String fullName, String emailAddress, String studentNo) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.studentNo = studentNo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}

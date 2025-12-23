package com.mph.dto;

public class OwnerDTO {
    private Long ownerId;
    private String name;
    private int age;
    private String contactNo;
    private String emailId;

    public OwnerDTO() {}

    public OwnerDTO(Long ownerId, String name, int age, String contactNo, String emailId) {
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.contactNo = contactNo;
        this.emailId = emailId;
    }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
}

package com.mph.dto;

public class TenantDTO
{
	private Long tenantId;
    private String name;
    private int age;
    private String contactNo;
    private Long pgId;
    
    
	public Long getTenantId() {
		return tenantId;
	}


	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public Long getPgId() {
		return pgId;
	}


	public void setPgId(Long pgId) {
		this.pgId = pgId;
	}


	public TenantDTO(Long tenantId, String name, int age, String contactNo, Long pgId) {
		super();
		this.tenantId = tenantId;
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.pgId = pgId;
	}
    
    
}

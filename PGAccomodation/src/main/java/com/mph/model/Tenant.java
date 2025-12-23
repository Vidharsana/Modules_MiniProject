package com.mph.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    private String name;
    private int age;
    private String contactNo;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    @JsonBackReference   //  prevents infinite recursion
    private PG pg;

	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tenant(Long tenantId, String name, int age, String contactNo, PG pg) {
		super();
		this.tenantId = tenantId;
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.pg = pg;
	}

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

	public PG getPg() {
		return pg;
	}

	public void setPg(PG pg) {
		this.pg = pg;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", name=" + name + ", age=" + age + ", contactNo=" + contactNo + ", pg="
				+ pg + "]";
	}

    
}

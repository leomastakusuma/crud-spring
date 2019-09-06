package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Person {

	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;
	
	

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updated_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void SetfirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getfirstName() {
		return firstName;
	}

	public void SetlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getlastName() {
		return lastName;
	}


	public Date getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(Date updated_at) {
		this.updated_at = updated_at;
	}


}

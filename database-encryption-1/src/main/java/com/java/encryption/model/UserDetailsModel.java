package com.java.encryption.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDetailsModel implements Serializable{
	private static final long serialVersionUID = -4841660351738042117L;

	private String emailId;
	private String mobileNumber;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
}

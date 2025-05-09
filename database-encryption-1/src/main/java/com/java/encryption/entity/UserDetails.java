package com.java.encryption.entity;

import java.io.Serializable;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 8987703994554237818L;

  @Id
  @GeneratedValue
  @UuidGenerator
  private String id;

  @ColumnTransformer(
      forColumn = "email_id",
      read = "CONVERT(AES_DECRYPT(email_id, 'email_idpassword') USING utf8)",
      write = "AES_ENCRYPT(?, 'email_idpassword')"
  )
  @Column(name = "email_id", columnDefinition = "BLOB")
  private String emailId;

  @ColumnTransformer(
      forColumn = "mobile_number",
      read = "CONVERT(AES_DECRYPT(mobile_number, 'mobile_numberpassword') USING utf8)",
      write = "AES_ENCRYPT(?, 'mobile_numberpassword')"
  )
  @Column(name = "mobile_number", columnDefinition = "BLOB")
  private String mobileNumber;

  @ColumnTransformer(
      forColumn = "first_name",
      read = "CONVERT(AES_DECRYPT(first_name, 'first_namepassword') USING utf8)",
      write = "AES_ENCRYPT(?, 'first_namepassword')"
  )
  @Column(name = "first_name", columnDefinition = "BLOB")
  private String firstName;

  @ColumnTransformer(
      forColumn = "last_name",
      read = "CONVERT(AES_DECRYPT(last_name, 'last_namepassword') USING utf8)",
      write = "AES_ENCRYPT(?, 'last_namepassword')"
  )
  @Column(name = "last_name", columnDefinition = "BLOB")
  private String lastName;

  @ColumnTransformer(
      forColumn = "address",
      read = "CONVERT(AES_DECRYPT(address, 'addresspassword') USING utf8)",
      write = "AES_ENCRYPT(?, 'addresspassword')"
  )
  @Column(name = "address", columnDefinition = "BLOB")
  private String address;

  @Column(name = "city")
  private String city;
}

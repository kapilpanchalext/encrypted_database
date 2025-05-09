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
	private static final String CONVERT_AES_DECRYPT = "CONVERT(AES_DECRYPT(";
	private static final String USING_UTF8 = " USING utf8)";
	private static final String KEY = "'password')";
	private static final String EMAIL_VALUE = 				CONVERT_AES_DECRYPT + "email_id, " 				+ KEY + USING_UTF8;
  private static final String MOBILE_NUMBER_VALUE = CONVERT_AES_DECRYPT + "mobile_number, " 	+ KEY + USING_UTF8;
	private static final String FIRST_NAME = 					CONVERT_AES_DECRYPT + "first_name, " 			+ KEY + USING_UTF8;
  private static final String LAST_NAME = 					CONVERT_AES_DECRYPT + "last_name, " 			+ KEY + USING_UTF8;
	private static final String ADDRESS = 						CONVERT_AES_DECRYPT + "address, " 				+ KEY + USING_UTF8;
	private static final String COLUMN_DEFINITION = "BLOB";
  private static final String DECRYPTION_VALUE = "AES_ENCRYPT(?, " + KEY;

	@Id
  @GeneratedValue
  @UuidGenerator
  private String id;

  @ColumnTransformer(
      forColumn = "email_id",
      read = EMAIL_VALUE,
      write = DECRYPTION_VALUE
  )
  @Column(name = "email_id", columnDefinition = COLUMN_DEFINITION)
  private String emailId;

  @ColumnTransformer(
      forColumn = "mobile_number",
      read = MOBILE_NUMBER_VALUE,
      write = DECRYPTION_VALUE
  )
  @Column(name = "mobile_number", columnDefinition = COLUMN_DEFINITION)
  private String mobileNumber;

  @ColumnTransformer(
      forColumn = "first_name",
      read = FIRST_NAME,
      write = DECRYPTION_VALUE
  )
  @Column(name = "first_name", columnDefinition = COLUMN_DEFINITION)
  private String firstName;

  @ColumnTransformer(
      forColumn = "last_name",
      read = LAST_NAME,
      write = DECRYPTION_VALUE
  )
  @Column(name = "last_name", columnDefinition = COLUMN_DEFINITION)
  private String lastName;

  @ColumnTransformer(
      forColumn = "address",
      read = ADDRESS,
      write = DECRYPTION_VALUE
  )
  @Column(name = "address", columnDefinition = COLUMN_DEFINITION)
  private String address;

  @Column(name = "city")
  private String city;
}

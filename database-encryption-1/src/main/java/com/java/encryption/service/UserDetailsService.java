package com.java.encryption.service;

import java.util.List;
import com.java.encryption.entity.UserDetails;
import com.java.encryption.model.UserDetailsModel;

public interface UserDetailsService {

	void saveUserDetails(UserDetailsModel userDetailsModel);

	List<UserDetails> getUserDetailsList();

}

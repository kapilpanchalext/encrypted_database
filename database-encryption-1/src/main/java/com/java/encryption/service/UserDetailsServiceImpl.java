package com.java.encryption.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.java.encryption.entity.UserDetails;
import com.java.encryption.model.UserDetailsModel;
import com.java.encryption.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	private final UserDetailsRepository userDetailsRepository;

	@Override
	public void saveUserDetails(UserDetailsModel userDetailsModel) {
		
		UserDetails userDetails =
				UserDetails
				.builder()
				.emailId(userDetailsModel.getEmailId())
				.mobileNumber(userDetailsModel.getMobileNumber())
				.firstName(userDetailsModel.getFirstName())
				.lastName(userDetailsModel.getLastName())
				.address(userDetailsModel.getAddress())
				.city(userDetailsModel.getCity())
				.build();
		
		userDetailsRepository.save(userDetails);
		
	}

	@Override
	public List<UserDetails> getUserDetailsList() {
		List<UserDetails> userDetailsList = userDetailsRepository.findAll();
		return userDetailsList;
	}

}

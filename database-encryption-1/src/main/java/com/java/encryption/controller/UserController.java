package com.java.encryption.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.encryption.entity.UserDetails;
import com.java.encryption.model.UserDetailsModel;
import com.java.encryption.service.UserDetailsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class UserController {
	private final UserDetailsService userDetailsService;

	@PostMapping(path = "/add")
	public ResponseEntity<String> saveUserDetails(@RequestBody UserDetailsModel userDetailsModel){

		userDetailsService.saveUserDetails(userDetailsModel);

		return ResponseEntity
								.status(HttpStatus.CREATED)
								.body("Created User Successfully!");
	}

	@GetMapping(path = "/get-user-list")
	public ResponseEntity<List<UserDetailsModel>> getUsersList(){

		List<UserDetails> userList = userDetailsService.getUserDetailsList();
		List<UserDetailsModel> usersDetailsModelList = new ArrayList<>();

		for(UserDetails element : userList) {
			UserDetailsModel userDetailsModel = 
					UserDetailsModel.builder()
					.emailId(element.getEmailId())
					.firstName(element.getFirstName())
					.lastName(element.getLastName())
					.address(element.getAddress())
					.city(element.getCity())
					.build();

			usersDetailsModelList.add(userDetailsModel);
		}

		return ResponseEntity.status(HttpStatus.OK).body(usersDetailsModelList);
	}

}

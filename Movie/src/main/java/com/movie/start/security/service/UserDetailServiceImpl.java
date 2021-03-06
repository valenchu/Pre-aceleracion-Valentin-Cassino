package com.movie.start.security.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.start.security.dto.UserDto;
import com.movie.start.security.entity.UserEntity;
import com.movie.start.security.mapper.UserMapper;
import com.movie.start.security.repository.UserRepository;
import com.movie.start.service.SendGridService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserMapper mapper;
	@Autowired
	private SendGridService sendGridService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username = "user";
		// Obtain the user to user DB
		UserEntity u = userRepo.findByUser(username);
		String usernameRepo = u.getUser();
		String pass = u.getPassword();

		if (username != null) {
			if (usernameRepo.equalsIgnoreCase(username)) {

				return new User(username, pass, Collections.emptyList());

			} else {
				throw new UsernameNotFoundException("Username or Password ICORRECT");
			}
		} else {
			throw new UsernameNotFoundException("Username or Password ICORRECT");
		}
	}

	public void saveUser(UserDto userDto, String pass) {
		UserEntity user = mapper.authentication2User(userDto);
		if (user.getUser() != null && !user.getUser().isEmpty()) {

			sendGridService.senEmail(user.getUser(), mapper.htmlWelcome(user.getUser(), pass));
		}
		userRepo.save(user);

	}

}

package com.example.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Security.entity.AuthenticationRequest;
import com.example.Security.entity.AuthenticationResponse;
import com.example.Security.jwt.JwtTokenUtil;

@RestController
public class HomeController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtTokenUtil jwtToeknUtil;

	@GetMapping("/")
	public String Home() {
		return ("</h1>Welcome</h1>");
	}
	
	@GetMapping("/user")
	public String User() {
		return ("</h1>Welcome User</h1>");
	}
	
	@GetMapping("/admin")
	public String Admin() {
		return ("</h1>Welcome Admin</h1>");
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> getAuthentication(@RequestBody AuthenticationRequest authRequest) throws Exception {
			
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));	
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		
		final String jwt = jwtToeknUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}

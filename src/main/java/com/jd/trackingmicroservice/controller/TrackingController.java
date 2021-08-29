package com.jd.trackingmicroservice.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.trackingmicroservice.dto.EndSessionDTO;
import com.jd.trackingmicroservice.dto.EventListDTO;
import com.jd.trackingmicroservice.dto.SessionDTO;
import com.jd.trackingmicroservice.entity.User;
import com.jd.trackingmicroservice.service.TrackingService;

@RestController
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;
	
	@PostMapping("/startSession")
	public ResponseEntity<User> startSession(@Valid @RequestBody SessionDTO sessiondto,HttpServletResponse response){
		/*
		 * if(result.hasErrors()) { return "Invalid Data"; }
		 */
		String sessionId = UUID.randomUUID().toString();
		sessiondto.setSessionId(UUID.fromString(sessionId));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Set-Cookie","sessionId="+sessionId);
		
		User user = trackingService.startSession(sessiondto);
		return new ResponseEntity<User>(user,headers,HttpStatus.CREATED);
			
	}
	
	@PostMapping("/endSession")
	public ResponseEntity<User> endSession(@Valid @RequestBody EndSessionDTO endSession) {
		trackingService.endSession(endSession);
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
	
	
	@PostMapping("/addEvent")
	public void addEvent(@Valid @RequestBody EventListDTO eventListDTO) {
		trackingService.addEvent(eventListDTO);
	}

}

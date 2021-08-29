package com.jd.trackingmicroservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jd.trackingmicroservice.dto.EndSessionDTO;
import com.jd.trackingmicroservice.dto.EventDTO;
import com.jd.trackingmicroservice.dto.EventListDTO;
import com.jd.trackingmicroservice.dto.SessionDTO;
import com.jd.trackingmicroservice.entity.Event;
import com.jd.trackingmicroservice.entity.User;
import com.jd.trackingmicroservice.repository.EventRepository;
import com.jd.trackingmicroservice.repository.UserRepository;
import com.jd.trackingmicroservice.service.TrackingService;

@Service
public class TrackingServiceImpl implements TrackingService{
	
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int batchSize;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private EventRepository eventRepository;

	@Override
	public void endSession(EndSessionDTO endSession) {
		// TODO Auto-generated method stub
		User user = userRepository.findBySessionId(endSession.getSessionId());
		user.setEndAt(endSession.getLogOffTime());
		userRepository.save(user);
	}

	@Override
	public void addEvent(EventListDTO eventListDTO) {
		// TODO Auto-generated method stub
		List<Event> events = new ArrayList<Event>();
		int counter = 0 ;
		for(EventDTO eventDetail : eventListDTO.getEvents()) {
			Event event = modelMapper.map(eventDetail, Event.class);
			event.setSessionId(eventListDTO.getSessionId());
			events.add(event);
			counter++;
			if(counter % batchSize==0 && counter >0) {
				eventRepository.saveAll(events);
				events.clear();
			}
		}	
	}

	@Override
	public User startSession(SessionDTO sessiondto) {
		// TODO Auto-generated method stub
		
		User user = modelMapper.map(sessiondto, User.class);
		return userRepository.save(user);	
	}

}

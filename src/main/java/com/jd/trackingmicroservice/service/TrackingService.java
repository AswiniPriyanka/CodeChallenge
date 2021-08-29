package com.jd.trackingmicroservice.service;

import com.jd.trackingmicroservice.dto.EndSessionDTO;
import com.jd.trackingmicroservice.dto.EventListDTO;
import com.jd.trackingmicroservice.dto.SessionDTO;
import com.jd.trackingmicroservice.entity.User;

public interface TrackingService {
	
	public User startSession(SessionDTO sessiondto);
	
	public void endSession(EndSessionDTO endSession);
	
	public void addEvent(EventListDTO eventListDTO);
	

}

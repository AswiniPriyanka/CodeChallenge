package com.jd.trackingmicroservice.dto;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EventListDTO {
	
	@NotNull(message = "SessionId is mandatory")
	private UUID sessionId;
	@NotEmpty(message = "Event List is mandatory")
	private List<EventDTO> events;

}

package com.jd.trackingmicroservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EventDTO {
	@NotNull(message="Event time is mandatory")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss")
	private LocalDateTime timestamp;
	private LocalDate eventAt;
	@NotNull(message="Event type is mandatory")
	private String eventType;
	private String payload;

}

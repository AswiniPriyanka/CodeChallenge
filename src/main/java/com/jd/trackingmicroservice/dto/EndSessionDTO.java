package com.jd.trackingmicroservice.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EndSessionDTO {
	
	@NotNull(message = "SessionId is mandatory")
	private UUID sessionId;
	@NotNull(message = "Log Off Time is mandatory")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss")
	private LocalDateTime logOffTime;

}

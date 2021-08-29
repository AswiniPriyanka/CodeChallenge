package com.jd.trackingmicroservice.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SessionDTO {
	
	private UUID userId;
	private UUID machineId;
	private UUID orgId;
	private UUID sessionId;	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss")
	
	@NotNull(message = "Start time can't be null")
	private LocalDateTime startAt;

}
